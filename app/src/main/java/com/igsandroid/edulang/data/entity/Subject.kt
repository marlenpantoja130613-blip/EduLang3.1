package com.igsandroid.edulang.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "subjects")
data class Subject(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val level: String,
    val language: String,
    val schedule: String,
    val capacity: Int,
    val teacherId: Int // ← CAMBIO AQUÍ
)