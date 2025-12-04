package com.igsandroid.edulang.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.igsandroid.edulang.data.entity.AppDatabase
import com.igsandroid.edulang.data.entity.Payment
import com.igsandroid.edulang.repository.PaymentRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PaymentViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: PaymentRepository

    private val _payments = MutableStateFlow<List<Payment>>(emptyList())
    val payments: StateFlow<List<Payment>> = _payments

    init {
        val paymentDao = AppDatabase.getDatabase(application).paymentDao()
        repository = PaymentRepository(paymentDao)
        loadPayments()
    }

    private fun loadPayments() {
        viewModelScope.launch {
            repository.allPayments.collect { paymentList ->
                _payments.value = paymentList
            }
        }
    }

    fun insertPayment(payment: Payment) {
        viewModelScope.launch {
            repository.insert(payment)
        }
    }

    fun updatePayment(payment: Payment) {
        viewModelScope.launch {
            repository.update(payment)
        }
    }

    fun deletePayment(payment: Payment) {
        viewModelScope.launch {
            repository.delete(payment)
        }
    }
}

