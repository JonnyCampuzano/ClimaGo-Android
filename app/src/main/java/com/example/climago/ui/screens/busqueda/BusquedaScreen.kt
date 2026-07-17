package com.example.climago.ui.screens.busqueda

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BusquedaScreen() {
    val ciudad = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text(text = "Buscar ciudad")

        OutlinedTextField(
            value = ciudad.value,
            onValueChange = {
                ciudad.value = it
            },
            label = {
                Text(text = "Nombre de la ciudad")
            }
        )
    }
}