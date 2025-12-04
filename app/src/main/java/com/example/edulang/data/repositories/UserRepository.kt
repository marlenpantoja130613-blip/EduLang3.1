package com.example.edulang.data.repositories

import com.example.edulang.data.dao.UserDao
import com.example.edulang.data.entities.UserEntity

class UserRepository(private val userDao: UserDao) {
    suspend fun getByEmail(email: String): UserEntity? = userDao.findByEmail(email)
    suspend fun insert(user: UserEntity) = userDao.insert(user)
}