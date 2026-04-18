package com.example.tarea_n2.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tarea_n2.ui.screens.HomeScreen
import com.example.tarea_n2.ui.screens.form.FormScreenCategory
import com.example.tarea_n2.ui.screens.form.FormViewModelCategory
import com.example.tarea_n2.ui.screens.form.FormViewModelEvent
import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
object FormCategory

@Composable
fun Navigation(){
    val navController = rememberNavController()
    val viewModel: FormViewModelCategory = viewModel()
    val viewModeltwo: FormViewModelEvent = viewModel()

    NavHost(navController = navController, startDestination = Home){
        composable<Home> {
            HomeScreen(navController, viewModel, viewModeltwo)
        }

        composable<FormCategory> {
            FormScreenCategory(navController, viewModel)
        }

    }
}

