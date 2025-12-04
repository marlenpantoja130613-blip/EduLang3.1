package com.igsandroid.edulang.repository

import com.igsandroid.edulang.data.dao.TeacherDao
import com.igsandroid.edulang.data.entity.Teacher
import kotlinx.coroutines.flow.Flow

class TeacherRepository(private val teacherDao: TeacherDao) {

    val allTeachers: Flow<List<Teacher>> = teacherDao.getAllTeachers()

    suspend fun insert(teacher: Teacher) {
        teacherDao.insert(teacher)
    }

    suspend fun update(teacher: Teacher) {
        teacherDao.update(teacher)
    }

    suspend fun delete(teacher: Teacher) {
        teacherDao.delete(teacher)
    }

    fun getTeacherById(teacherId: Int): Flow<Teacher?> {
        return teacherDao.getTeacherById(teacherId)
    }

    suspend fun getTeacherByUserId(userId: Int): Teacher? {
        return teacherDao.getTeacherByUserId(userId)
    }
}

