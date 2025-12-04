package com.igsandroid.edulang.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "teachers")
data class Teacher(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val userId: Int, // Referencia al User
    val specialty: String,
    val availability: String,
    val phone: String,
    val hireDate: String
)