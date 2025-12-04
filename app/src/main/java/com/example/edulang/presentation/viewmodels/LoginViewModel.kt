package com.example.edulang.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.example.edulang.domain.usecases.LoginUseCase

class LoginViewModel(private val loginUseCase: LoginUseCase) : ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState

    fun onEmailChanged(email: String) {
        _uiState.value = _uiState.value.copy(email = email)
    }
    fun onPasswordChanged(password: String) {
        _uiState.value = _uiState.value.copy(password = password)
    }
    fun login(onResult: (Boolean) -> Unit) {
        val email = _uiState.value.email
        val password = _uiState.value.password
        viewModelScope.launch {
            val success = loginUseCase(email, password)
            onResult(success)
        }
    }
}

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val error: String? = null
)