package com.example.edulang.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.edulang.data.entities.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM users WHERE email = :email LIMIT 1")
    suspend fun findByEmail(email: String): UserEntity?

    @Insert
    suspend fun insert(user: UserEntity): Long
}