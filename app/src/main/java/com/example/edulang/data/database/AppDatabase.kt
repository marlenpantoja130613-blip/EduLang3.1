package com.example.edulang.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.edulang.data.entities.UserEntity
import com.example.edulang.data.dao.UserDao

@Database(entities = [UserEntity::class /*, StudentEntity, TeacherEntity, ... */], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    // otras DAO: studentDao(), teacherDao(), courseDao(), enrollmentDao(), paymentDao()
}