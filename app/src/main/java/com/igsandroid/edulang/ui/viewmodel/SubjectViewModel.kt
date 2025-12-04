package com.igsandroid.edulang.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.igsandroid.edulang.data.entity.AppDatabase
import com.igsandroid.edulang.data.entity.Subject
import com.igsandroid.edulang.repository.SubjectRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SubjectViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: SubjectRepository

    private val _subjects = MutableStateFlow<List<Subject>>(emptyList())
    val subjects: StateFlow<List<Subject>> = _subjects

    init {
        val subjectDao = AppDatabase.getDatabase(application).subjectDao()
        repository = SubjectRepository(subjectDao)
        loadSubjects()
    }

    private fun loadSubjects() {
        viewModelScope.launch {
            repository.allSubjects.collect { subjectList ->
                _subjects.value = subjectList
            }
        }
    }

    fun insertSubject(subject: Subject) {
        viewModelScope.launch {
            repository.insert(subject)
        }
    }

    fun updateSubject(subject: Subject) {
        viewModelScope.launch {
            repository.update(subject)
        }
    }

    fun deleteSubject(subject: Subject) {
        viewModelScope.launch {
            repository.delete(subject)
        }
    }
}

