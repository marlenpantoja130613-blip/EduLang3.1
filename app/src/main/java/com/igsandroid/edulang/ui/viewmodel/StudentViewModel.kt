package com.igsandroid.edulang.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.igsandroid.edulang.data.entity.AppDatabase
import com.igsandroid.edulang.data.entity.Student
import com.igsandroid.edulang.repository.StudentRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class StudentViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: StudentRepository

    private val _students = MutableStateFlow<List<Student>>(emptyList())
    val students: StateFlow<List<Student>> = _students

    init {
        val studentDao = AppDatabase.getDatabase(application).studentDao()
        repository = StudentRepository(studentDao)
        loadStudents()
    }

    private fun loadStudents() {
        viewModelScope.launch {
            repository.allStudents.collect { studentList ->
                _students.value = studentList
            }
        }
    }

    fun insertStudent(student: Student) {
        viewModelScope.launch {
            repository.insert(student)
        }
    }

    fun updateStudent(student: Student) {
        viewModelScope.launch {
            repository.update(student)
        }
    }

    fun deleteStudent(student: Student) {
        viewModelScope.launch {
            repository.delete(student)
        }
    }
}

