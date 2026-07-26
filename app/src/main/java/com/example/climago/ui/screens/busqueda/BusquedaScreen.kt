package com.example.climago.ui.screens.busqueda

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.climago.data.repository.RepositoryProvider
import com.example.climago.domain.model.Ciudad

@Composable
fun BusquedaScreen(
    onCiudadClick: (Ciudad) -> Unit
) {
    val factory = BusquedaViewModelFactory(
        repository = RepositoryProvider.climaRepository
    )

    val viewModel: BusquedaViewModel = viewModel(
        factory = factory
    )

    val texto by viewModel.textoBusqueda.collectAsState()
    val estado by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(text = "Buscar ciudad")

        OutlinedTextField(
            value = texto,
            onValueChange = viewModel::actualizarTexto,
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Nombre de la ciudad")
            },
            singleLine = true
        )

        Button(
            onClick = viewModel::buscarCiudades,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Buscar")
        }

        when (val resultado = estado) {

            BusquedaUiState.Inicial -> {
                Text(
                    text = "Escribe una ciudad para comenzar."
                )
            }

            BusquedaUiState.Cargando -> {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            is BusquedaUiState.Exito -> {
                if (resultado.ciudades.isEmpty()) {
                    Text(
                        text = "No se encontraron ciudades."
                    )
                } else {
                    LazyColumn(
                        verticalArrangement =
                            Arrangement.spacedBy(8.dp)
                    ) {
                        items(
                            items = resultado.ciudades,
                            key = { ciudad -> ciudad.id }
                        ) { ciudad ->
                            CiudadItem(
                                ciudad = ciudad,
                                onClick = {
                                    onCiudadClick(ciudad)
                                }
                            )
                        }
                    }
                }
            }

            is BusquedaUiState.Error -> {
                Text(text = resultado.mensaje)
            }
        }
    }
}

@Composable
private fun CiudadItem(
    ciudad: Ciudad,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(text = ciudad.nombre)

            HorizontalDivider()

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "${ciudad.region}, ${ciudad.pais}"
                )
            }

            Text(
                text = "Latitud: ${ciudad.latitud}"
            )

            Text(
                text = "Longitud: ${ciudad.longitud}"
            )
        }
    }
}