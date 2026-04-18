package com.example.tarea_n2.ui.screens.form

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class FormViewModelEvent : ViewModel(){
    var nombre by mutableStateOf("")
    var fecha_hora by mutableStateOf("")
    var category by mutableStateOf("")
    var listEvent = mutableListOf<Event>()
    var ultimoid = 0

    init {
        cargarDatos()
    }

    fun cargarDatos() {
        val datos = listOf(
            Event(1, "Final Champions League", "2026-05-30 21:00", "Deportes"),
            Event(2, "Concierto Dua Lipa", "2026-06-15 20:00", "Musica"),
            Event(3, "Lanzamiento Android 17", "2026-08-10 10:00", "Tecnologia"),
            Event(4, "Feria Gastronomica", "2026-09-05 12:00", "Musica"),
            Event(5, "Feria Gastronomica", "2026-09-05 12:00", "Musica")
        )

        listEvent.addAll(datos)
        ultimoid = datos.size
    }

    fun addEvent(){
        ultimoid++

        listEvent.add(Event(ultimoid, nombre, fecha_hora,category ))
        nombre = ""
        fecha_hora = ""
        category = ""
    }
}

class Event(val id:Int, val nombre: String, val fecha_hora: String, val category: String)