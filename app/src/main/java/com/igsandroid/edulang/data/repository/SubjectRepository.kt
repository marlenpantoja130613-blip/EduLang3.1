package com.igsandroid.edulang.repository

import com.igsandroid.edulang.data.dao.SubjectDao
import com.igsandroid.edulang.data.entity.Subject
import kotlinx.coroutines.flow.Flow

class SubjectRepository(private val subjectDao: SubjectDao) {

    val allSubjects: Flow<List<Subject>> = subjectDao.getAllSubjects()

    suspend fun insert(subject: Subject) {
        subjectDao.insert(subject)
    }

    suspend fun update(subject: Subject) {
        subjectDao.update(subject)
    }

    suspend fun delete(subject: Subject) {
        subjectDao.delete(subject)
    }

    fun getSubjectById(subjectId: Int): Flow<Subject?> {
        return subjectDao.getSubjectById(subjectId)
    }

    fun getSubjectsByTeacher(teacherId: Int): Flow<List<Subject>> {
        return subjectDao.getSubjectsByTeacher(teacherId)
    }

    fun getSubjectsByLanguage(language: String): Flow<List<Subject>> {
        return subjectDao.getSubjectsByLanguage(language)
    }
}

