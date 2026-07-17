package com.example.climago.ui.screens.inicio

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun InicioScreen(
    onBuscarClick: () -> Unit,
    onFavoritosClick: () -> Unit,
    onConfiguracionClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "ClimaGo")

        Text(text = "Guayaquil")

        Text(text = "30 °C")

        Text(text = "Parcialmente nublado")

        Button(onClick = onBuscarClick) {
            Text(text = "Buscar ciudad")
        }

        Button(onClick = onFavoritosClick) {
            Text(text = "Ver favoritos")
        }

        Button(onClick = onConfiguracionClick) {
            Text(text = "Configuración")
        }
    }
}