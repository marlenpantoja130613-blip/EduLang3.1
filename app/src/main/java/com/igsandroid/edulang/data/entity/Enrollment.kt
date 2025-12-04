package com.igsandroid.edulang.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "enrollments")
data class Enrollment(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val studentId: Int,
    val subjectId: Int,
    val enrollmentDate: String,
    val status: String // "activo", "completado", "cancelado"
)
