package com.example.tarea_n2.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tarea_n2.ui.components.BotonForm
import com.example.tarea_n2.ui.navigation.FormCategory
import com.example.tarea_n2.ui.screens.form.FormViewModelCategory
import com.example.tarea_n2.ui.screens.form.FormViewModelEvent

@Composable
fun HomeScreen(navController: NavController, viewModel: FormViewModelCategory, viewModeltwo: FormViewModelEvent){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Row(
                modifier = Modifier.fillMaxWidth().height(80.dp)
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "EventMaster",
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        bottomBar = {
            Row(
                modifier = Modifier.fillMaxWidth().height(80.dp)
                    .background(MaterialTheme.colorScheme.secondary)
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                BotonForm(
                    texto = "Registro Categoria",
                    onClick = { navController.navigate(FormCategory) }
                )

                BotonForm(
                    texto = "Registro Evento",
                    onClick = {  }
                )
            }
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            GridCards(viewModel,viewModeltwo)
        }
    }
}

@Composable
fun GridCards(viewModel: FormViewModelCategory, viewModeltwo: FormViewModelEvent) {

    var selected by remember { mutableIntStateOf(0) }

    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        contentPadding = PaddingValues(horizontal = 50.dp, vertical = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        for (categoria in viewModel.listCategory) {
            item(span = { GridItemSpan(maxLineSpan) }) {
                Text(
                    text = categoria.nombre,
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(bottom = 3.dp)
                )
            }

            items(viewModeltwo.listEvent.filter { it.category == categoria.nombre }) {
                Card(
                    colors = CardDefaults.cardColors(),
                    onClick = { selected = it.id }
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            modifier = Modifier.padding(top = 10.dp).fillMaxWidth(.9f),
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Text(it.nombre)
                        }
                    }
                }

            }
        }
    }
}






