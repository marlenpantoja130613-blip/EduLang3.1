package com.example.edulang.presentation.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.material3.*

@Composable
fun LoginScreen(navController: NavController) {
    // UI stub: inputs + button. Validación simple y navegación a "home" si ok.
    // Este archivo será completado con TextFields, validación en tiempo real y Snackbar.
    Surface {
        Button(onClick = { navController.navigate("home") }) {
            Text("Entrar (demo)")
        }
    }
}