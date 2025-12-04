package com.example.edulang

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.edulang.presentation.ui.theme.EduLangTheme
import com.example.edulang.navigation.AppNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EduLangTheme {
                AppNavHost() // NavHost con rutas: login, home, students, ...
            }
        }
    }
}