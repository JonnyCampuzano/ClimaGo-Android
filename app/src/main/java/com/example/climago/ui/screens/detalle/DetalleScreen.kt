package com.example.climago.ui.screens.detalle

import com.example.climago.ui.domain.models.WeatherCodeMapper
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.climago.data.repository.RepositoryProvider

@Composable
fun DetalleScreen(
    nombreCiudad: String,
    latitud: Double,
    longitud: Double
) {
    val factory = DetalleViewModelFactory(
        repository = RepositoryProvider.climaRepository
    )

    val viewModel: DetalleViewModel = viewModel(
        factory = factory
    )

    val estado by viewModel.uiState.collectAsState()

    LaunchedEffect(latitud, longitud) {
        viewModel.cargarClima(
            latitud = latitud,
            longitud = longitud
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        when (val resultado = estado) {

            DetalleUiState.Cargando -> {
                CircularProgressIndicator()
            }

            is DetalleUiState.Exito -> {
                val clima = resultado.clima

                val descripcionClima =
                    WeatherCodeMapper.obtenerDescripcion(clima.codigoClima)

                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(20.dp),
                        verticalArrangement =
                            Arrangement.spacedBy(12.dp)
                    ) {
                        Text(text = nombreCiudad)

                        Text(
                            text =
                                "${clima.temperatura} °C"
                        )

                        Text(
                            text = descripcionClima
                        )

                        Text(
                            text =
                                "Sensación térmica: " +
                                        "${clima.sensacionTermica} °C"
                        )

                        Text(
                            text =
                                "Humedad: ${clima.humedad}%"
                        )

                        Text(
                            text =
                                "Precipitación: " +
                                        "${clima.precipitacion} mm"
                        )

                        Text(
                            text =
                                "Viento: " +
                                        "${clima.velocidadViento} km/h"
                        )
                    }
                }
            }

            is DetalleUiState.Error -> {
                Column(
                    horizontalAlignment =
                        Alignment.CenterHorizontally,
                    verticalArrangement =
                        Arrangement.spacedBy(12.dp)
                ) {
                    Text(text = resultado.mensaje)

                    Button(
                        onClick = {
                            viewModel.cargarClima(
                                latitud = latitud,
                                longitud = longitud
                            )
                        }
                    ) {
                        Text(text = "Reintentar")
                    }
                }
            }
        }
    }
}