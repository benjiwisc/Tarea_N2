package com.example.tarea_n2.ui.screens.form

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.tarea_n2.ui.components.BotonForm
import com.example.tarea_n2.ui.components.InputForm
import com.example.tarea_n2.ui.navigation.Home

@Composable
fun FormScreenCategory(navController: NavHostController, formViewModel: FormViewModelCategory) {
    Scaffold() { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Nueva Categoría",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            InputForm(
                label = "Nombre de la categoría",
                value = formViewModel.nombre,
                onValueChange = { formViewModel.nombre = it },
                error = formViewModel.nombreError
            )

            Spacer(modifier = Modifier.size(22.dp))

            InputForm(
                label = "Nombre del encargado",
                value = formViewModel.encargado,
                onValueChange = { formViewModel.encargado = it },
                error = formViewModel.encargadoError
            )

            Spacer(modifier = Modifier.size(32.dp))

            BotonForm(
                texto = "Añadir Categoría",
                onClick = { formViewModel.addCategory() }
            )

            Spacer(modifier = Modifier.size(12.dp))

            BotonForm(
                texto = "Volver",
                onClick = { navController.navigate(Home) }
            )
        }
    }
}

