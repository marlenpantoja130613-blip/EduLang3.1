package com.igsandroid.edulang.data.dao

import androidx.room.*
import com.igsandroid.edulang.data.entity.Payment
import kotlinx.coroutines.flow.Flow

@Dao
interface PaymentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(payment: Payment)

    @Update
    suspend fun update(payment: Payment)

    @Delete
    suspend fun delete(payment: Payment)

    @Query("SELECT * FROM payments")
    fun getAllPayments(): Flow<List<Payment>>

    @Query("SELECT * FROM payments WHERE studentId = :studentId")
    fun getPaymentsByStudent(studentId: Int): Flow<List<Payment>>

    @Query("SELECT * FROM payments WHERE enrollmentId = :enrollmentId")
    fun getPaymentsByEnrollment(enrollmentId: Int): Flow<List<Payment>>

    @Query("SELECT * FROM payments WHERE status = :status")
    fun getPaymentsByStatus(status: String): Flow<List<Payment>>
}

