package com.example.climago.ui.screens.configuracion

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ConfiguracionScreen() {
    val modoOscuro = remember {
        mutableStateOf(false)
    }

    Row(
        modifier = Modifier.padding(24.dp)
    ) {
        Text(
            text = "Modo oscuro",
            modifier = Modifier.weight(1f)
        )

        Switch(
            checked = modoOscuro.value,
            onCheckedChange = {
                modoOscuro.value = it
            }
        )
    }
}