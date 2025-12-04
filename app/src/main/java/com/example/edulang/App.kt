package com.example.edulang

import android.app.Application

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        // Inicializaciones globales (Room DB singleton inicializado después)
    }
}