package com.example.edulang.domain.usecases

import com.example.edulang.data.repositories.UserRepository

class LoginUseCase(private val repo: UserRepository) {
    suspend operator fun invoke(email: String, password: String) =
        repo.getByEmail(email)?.let { it.password == password } ?: false
}