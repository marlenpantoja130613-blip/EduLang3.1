package com.igsandroid.edulang.ui.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Home : Screen("home")
    object Students : Screen("students")
    object Teachers : Screen("teachers")
    object Subjects : Screen("subjects")
    object Enrollments : Screen("enrollments")
    object Payments : Screen("payments")
}

