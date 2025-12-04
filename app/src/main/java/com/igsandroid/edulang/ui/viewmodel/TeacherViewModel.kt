package com.igsandroid.edulang.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.igsandroid.edulang.data.entity.AppDatabase
import com.igsandroid.edulang.data.entity.Teacher
import com.igsandroid.edulang.repository.TeacherRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TeacherViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: TeacherRepository

    private val _teachers = MutableStateFlow<List<Teacher>>(emptyList())
    val teachers: StateFlow<List<Teacher>> = _teachers

    init {
        val teacherDao = AppDatabase.getDatabase(application).teacherDao()
        repository = TeacherRepository(teacherDao)
        loadTeachers()
    }

    private fun loadTeachers() {
        viewModelScope.launch {
            repository.allTeachers.collect { teacherList ->
                _teachers.value = teacherList
            }
        }
    }

    fun insertTeacher(teacher: Teacher) {
        viewModelScope.launch {
            repository.insert(teacher)
        }
    }

    fun updateTeacher(teacher: Teacher) {
        viewModelScope.launch {
            repository.update(teacher)
        }
    }

    fun deleteTeacher(teacher: Teacher) {
        viewModelScope.launch {
            repository.delete(teacher)
        }
    }
}

