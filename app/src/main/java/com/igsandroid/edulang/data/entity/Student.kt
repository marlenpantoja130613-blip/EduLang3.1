package com.igsandroid.edulang.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "students")
data class Student(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val userId: Int, // Referencia al User
    val registrationNumber: String,
    val phone: String,
    val address: String,
    val birthDate: String,
    val enrollmentDate: String
)