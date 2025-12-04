package com.igsandroid.edulang.repository

import com.igsandroid.edulang.data.dao.UserDao
import com.igsandroid.edulang.data.entity.User
import kotlinx.coroutines.flow.Flow

class UserRepository(private val userDao: UserDao) {

    val allUsers: Flow<List<User>> = userDao.getAllUsers()

    suspend fun insert(user: User) {
        userDao.insert(user)
    }

    suspend fun update(user: User) {
        userDao.update(user)
    }

    suspend fun delete(user: User) {
        userDao.delete(user)
    }

    suspend fun login(username: String, password: String): User? {
        return userDao.login(username, password)
    }

    fun getUserById(userId: Int): Flow<User?> {
        return userDao.getUserById(userId)
    }

    fun getUsersByRole(role: String): Flow<List<User>> {
        return userDao.getUsersByRole(role)
    }
}
