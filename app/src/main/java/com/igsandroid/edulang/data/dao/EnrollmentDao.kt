package com.igsandroid.edulang.data.dao

import androidx.room.*
import com.igsandroid.edulang.data.entity.Enrollment
import kotlinx.coroutines.flow.Flow

@Dao
interface EnrollmentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(enrollment: Enrollment)

    @Update
    suspend fun update(enrollment: Enrollment)

    @Delete
    suspend fun delete(enrollment: Enrollment)

    @Query("SELECT * FROM enrollments")
    fun getAllEnrollments(): Flow<List<Enrollment>>

    @Query("SELECT * FROM enrollments WHERE studentId = :studentId")
    fun getEnrollmentsByStudent(studentId: Int): Flow<List<Enrollment>>

    @Query("SELECT * FROM enrollments WHERE subjectId = :subjectId")
    fun getEnrollmentsBySubject(subjectId: Int): Flow<List<Enrollment>>

    @Query("SELECT * FROM enrollments WHERE id = :enrollmentId")
    fun getEnrollmentById(enrollmentId: Int): Flow<Enrollment?>
}

