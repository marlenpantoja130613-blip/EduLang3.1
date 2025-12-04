package com.igsandroid.edulang.data.dao

import androidx.room.*
import com.igsandroid.edulang.data.entity.Student
import kotlinx.coroutines.flow.Flow

@Dao
interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(student: Student)

    @Update
    suspend fun update(student: Student)

    @Delete
    suspend fun delete(student: Student)

    @Query("SELECT * FROM students")
    fun getAllStudents(): Flow<List<Student>>

    @Query("SELECT * FROM students WHERE id = :studentId")
    fun getStudentById(studentId: Int): Flow<Student?>

    @Query("SELECT * FROM students WHERE userId = :userId")
    suspend fun getStudentByUserId(userId: Int): Student?
}
