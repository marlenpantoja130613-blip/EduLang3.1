package com.example.edulang.presentation.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun EduLangTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        // colors, typography y shapes se agregarán aquí
        content = content
    )
}