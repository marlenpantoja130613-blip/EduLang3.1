package com.igsandroid.edulang.data.dao

import androidx.room.*
import com.igsandroid.edulang.data.entity.Subject
import kotlinx.coroutines.flow.Flow

@Dao
interface SubjectDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(subject: Subject)

    @Update
    suspend fun update(subject: Subject)

    @Delete
    suspend fun delete(subject: Subject)

    @Query("SELECT * FROM subjects")
    fun getAllSubjects(): Flow<List<Subject>>

    @Query("SELECT * FROM subjects WHERE id = :subjectId")
    fun getSubjectById(subjectId: Int): Flow<Subject?>

    @Query("SELECT * FROM subjects WHERE teacherId = :teacherId") // ← CAMBIO AQUÍ
    fun getSubjectsByTeacher(teacherId: Int): Flow<List<Subject>>

    @Query("SELECT * FROM subjects WHERE language = :language")
    fun getSubjectsByLanguage(language: String): Flow<List<Subject>>
}