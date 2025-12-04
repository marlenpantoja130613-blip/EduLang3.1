package com.igsandroid.edulang.repository

import com.igsandroid.edulang.data.dao.StudentDao
import com.igsandroid.edulang.data.entity.Student
import kotlinx.coroutines.flow.Flow

class StudentRepository(private val studentDao: StudentDao) {

    val allStudents: Flow<List<Student>> = studentDao.getAllStudents()

    suspend fun insert(student: Student) {
        studentDao.insert(student)
    }

    suspend fun update(student: Student) {
        studentDao.update(student)
    }

    suspend fun delete(student: Student) {
        studentDao.delete(student)
    }

    fun getStudentById(studentId: Int): Flow<Student?> {
        return studentDao.getStudentById(studentId)
    }

    suspend fun getStudentByUserId(userId: Int): Student? {
        return studentDao.getStudentByUserId(userId)
    }
}

