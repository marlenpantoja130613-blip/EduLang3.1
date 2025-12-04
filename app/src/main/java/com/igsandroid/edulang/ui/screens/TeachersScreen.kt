package com.igsandroid.edulang.ui.screens

import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.igsandroid.edulang.data.entity.Teacher
import com.igsandroid.edulang.ui.viewmodel.TeacherViewModel
import com.igsandroid.edulang.ui.viewmodel.TeacherViewModelFactory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TeachersScreen(
    navController: NavController,
    viewModel: TeacherViewModel = viewModel(
        factory = TeacherViewModelFactory(
            LocalContext.current.applicationContext as Application
        )
    )
) {
    val teachers by viewModel.teachers.collectAsState()
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Docentes") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, "Volver")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { showDialog = true }) {
                Icon(Icons.Default.Add, "Agregar")
            }
        }
    ) { paddingValues ->
        if (teachers.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = androidx.compose.ui.Alignment.Center
            ) {
                Text("No hay docentes registrados")
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp)
            ) {
                items(teachers) { teacher ->
                    TeacherCard(teacher = teacher)
                }
            }
        }
    }

    if (showDialog) {
        AddTeacherDialog(
            onDismiss = { showDialog = false },
            onConfirm = { teacher ->
                viewModel.insertTeacher(teacher)
                showDialog = false
            }
        )
    }
}

@Composable
fun TeacherCard(teacher: Teacher) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Especialidad: ${teacher.specialty}",
                style = MaterialTheme.typography.titleMedium
            )
            Text(text = "Teléfono: ${teacher.phone}")
            Text(text = "Disponibilidad: ${teacher.availability}")
            Text(text = "Fecha de Contratación: ${teacher.hireDate}")
        }
    }
}

@Composable
fun AddTeacherDialog(
    onDismiss: () -> Unit,
    onConfirm: (Teacher) -> Unit
) {
    var specialty by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var availability by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Agregar Docente") },
        text = {
            Column {
                OutlinedTextField(
                    value = specialty,
                    onValueChange = { specialty = it },
                    label = { Text("Especialidad") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = phone,
                    onValueChange = { phone = it },
                    label = { Text("Teléfono") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = availability,
                    onValueChange = { availability = it },
                    label = { Text("Disponibilidad") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        confirmButton = {
            Button(onClick = {
                val currentDate = java.text.SimpleDateFormat(
                    "yyyy-MM-dd",
                    java.util.Locale.getDefault()
                ).format(java.util.Date())

                val teacher = Teacher(
                    userId = 1,
                    specialty = specialty,
                    availability = availability,
                    phone = phone,
                    hireDate = currentDate
                )
                onConfirm(teacher)
            }) {
                Text("Guardar")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancelar")
            }
        }
    )
}