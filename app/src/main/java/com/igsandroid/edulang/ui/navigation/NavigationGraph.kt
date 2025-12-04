package com.igsandroid.edulang.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.igsandroid.edulang.ui.screens.*

@Composable
fun NavigationGraph(
    navController: NavHostController,
    startDestination: String = Screen.Login.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screen.Login.route) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                }
            )
        }

        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(Screen.Students.route) {
            StudentsScreen(navController = navController)
        }

        composable(Screen.Teachers.route) {
            TeachersScreen(navController = navController)
        }

        composable(Screen.Subjects.route) {
            SubjectsScreen(navController = navController)
        }

        composable(Screen.Enrollments.route) {
            EnrollmentsScreen(navController = navController)
        }

        composable(Screen.Payments.route) {
            PaymentsScreen(navController = navController)
        }
    }
}

