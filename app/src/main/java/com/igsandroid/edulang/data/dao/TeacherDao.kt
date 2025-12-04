package com.igsandroid.edulang.data.dao

import androidx.room.*
import com.igsandroid.edulang.data.entity.Teacher
import kotlinx.coroutines.flow.Flow

@Dao
interface TeacherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(teacher: Teacher)

    @Update
    suspend fun update(teacher: Teacher)

    @Delete
    suspend fun delete(teacher: Teacher)

    @Query("SELECT * FROM teachers")
    fun getAllTeachers(): Flow<List<Teacher>>

    @Query("SELECT * FROM teachers WHERE id = :teacherId")
    fun getTeacherById(teacherId: Int): Flow<Teacher?>

    @Query("SELECT * FROM teachers WHERE userId = :userId")
    suspend fun getTeacherByUserId(userId: Int): Teacher?
}

