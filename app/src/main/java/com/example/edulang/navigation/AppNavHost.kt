package com.example.edulang.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.edulang.presentation.ui.screens.LoginScreen
import com.example.edulang.presentation.ui.screens.HomeScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController) }
        composable("home") { HomeScreen(navController) }
        // otras rutas: students, studentDetail/{id}, teachers, courses, enrollments, payments
    }
}