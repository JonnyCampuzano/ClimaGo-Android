package com.example.climago.ui.screens.favoritos

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun FavoritosScreen() {
    val ciudades = listOf(
        "Guayaquil",
        "Quito",
        "Cuenca"
    )

    LazyColumn {
        items(ciudades) { ciudad ->
            Text(text = ciudad)
        }
    }
}