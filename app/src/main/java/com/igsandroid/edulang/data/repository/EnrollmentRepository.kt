package com.igsandroid.edulang.repository

import com.igsandroid.edulang.data.dao.EnrollmentDao
import com.igsandroid.edulang.data.entity.Enrollment
import kotlinx.coroutines.flow.Flow

class EnrollmentRepository(private val enrollmentDao: EnrollmentDao) {

    val allEnrollments: Flow<List<Enrollment>> = enrollmentDao.getAllEnrollments()

    suspend fun insert(enrollment: Enrollment) {
        enrollmentDao.insert(enrollment)
    }

    suspend fun update(enrollment: Enrollment) {
        enrollmentDao.update(enrollment)
    }

    suspend fun delete(enrollment: Enrollment) {
        enrollmentDao.delete(enrollment)
    }

    fun getEnrollmentsByStudent(studentId: Int): Flow<List<Enrollment>> {
        return enrollmentDao.getEnrollmentsByStudent(studentId)
    }

    fun getEnrollmentsBySubject(subjectId: Int): Flow<List<Enrollment>> {
        return enrollmentDao.getEnrollmentsBySubject(subjectId)
    }

    fun getEnrollmentById(enrollmentId: Int): Flow<Enrollment?> {
        return enrollmentDao.getEnrollmentById(enrollmentId)
    }
}

