package com.igsandroid.edulang.repository

import com.igsandroid.edulang.data.dao.PaymentDao
import com.igsandroid.edulang.data.entity.Payment
import kotlinx.coroutines.flow.Flow

class PaymentRepository(private val paymentDao: PaymentDao) {

    val allPayments: Flow<List<Payment>> = paymentDao.getAllPayments()

    suspend fun insert(payment: Payment) {
        paymentDao.insert(payment)
    }

    suspend fun update(payment: Payment) {
        paymentDao.update(payment)
    }

    suspend fun delete(payment: Payment) {
        paymentDao.delete(payment)
    }

    fun getPaymentsByStudent(studentId: Int): Flow<List<Payment>> {
        return paymentDao.getPaymentsByStudent(studentId)
    }

    fun getPaymentsByEnrollment(enrollmentId: Int): Flow<List<Payment>> {
        return paymentDao.getPaymentsByEnrollment(enrollmentId)
    }

    fun getPaymentsByStatus(status: String): Flow<List<Payment>> {
        return paymentDao.getPaymentsByStatus(status)
    }
}

