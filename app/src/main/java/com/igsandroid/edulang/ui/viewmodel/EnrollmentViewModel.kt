package com.igsandroid.edulang.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.igsandroid.edulang.data.entity.AppDatabase
import com.igsandroid.edulang.data.entity.Enrollment
import com.igsandroid.edulang.repository.EnrollmentRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EnrollmentViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: EnrollmentRepository

    private val _enrollments = MutableStateFlow<List<Enrollment>>(emptyList())
    val enrollments: StateFlow<List<Enrollment>> = _enrollments

    init {
        val enrollmentDao = AppDatabase.getDatabase(application).enrollmentDao()
        repository = EnrollmentRepository(enrollmentDao)
        loadEnrollments()
    }

    private fun loadEnrollments() {
        viewModelScope.launch {
            repository.allEnrollments.collect { enrollmentList ->
                _enrollments.value = enrollmentList
            }
        }
    }

    fun insertEnrollment(enrollment: Enrollment) {
        viewModelScope.launch {
            repository.insert(enrollment)
        }
    }

    fun updateEnrollment(enrollment: Enrollment) {
        viewModelScope.launch {
            repository.update(enrollment)
        }
    }

    fun deleteEnrollment(enrollment: Enrollment) {
        viewModelScope.launch {
            repository.delete(enrollment)
        }
    }
}

