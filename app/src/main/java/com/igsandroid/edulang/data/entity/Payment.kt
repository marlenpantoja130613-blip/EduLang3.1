package com.igsandroid.edulang.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "payments")
data class Payment(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val studentId: Int,
    val enrollmentId: Int,
    val amount: Double,
    val paymentDate: String,
    val paymentType: String, // "inscripción", "mensualidad"
    val status: String // "pagado", "pendiente", "vencido"
)

