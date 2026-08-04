package com.example.climago.ui.screens.favoritos

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.climago.ClimaGoApplication
import com.example.climago.domain.model.CiudadFavorita
import com.example.climago.ui.screens.favorito.FavoritosViewModel
import com.example.climago.ui.screens.favorito.FavoritosViewModelFactory

@Composable
fun FavoritosScreen(
    onCiudadClick: (CiudadFavorita) -> Unit
) {
    /*
    |--------------------------------------------------------------------------
    | OBTENER LA APLICACIÓN
    |--------------------------------------------------------------------------
    */

    val context = LocalContext.current

    val application =
        context.applicationContext as ClimaGoApplication

    /*
    |--------------------------------------------------------------------------
    | CREAR EL FACTORY
    |--------------------------------------------------------------------------
    */

    val factory = remember(application) {
        FavoritosViewModelFactory(
            repository = application.container.climaRepository
        )
    }

    /*
    |--------------------------------------------------------------------------
    | CREAR EL VIEWMODEL
    |--------------------------------------------------------------------------
    */

    val viewModel: FavoritosViewModel = viewModel(
        factory = factory
    )

    /*
    |--------------------------------------------------------------------------
    | OBSERVAR EL ESTADO
    |--------------------------------------------------------------------------
    */

    val estado by viewModel.uiState
        .collectAsStateWithLifecycle()

    /*
    |--------------------------------------------------------------------------
    | MOSTRAR LA INTERFAZ SEGÚN EL ESTADO
    |--------------------------------------------------------------------------
    */

    when {
        estado.cargando -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        estado.mensajeError != null -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = estado.mensajeError
                        ?: "Ocurrió un error desconocido."
                )
            }
        }

        estado.ciudades.isEmpty() -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Todavía no tienes ciudades favoritas."
                )
            }
        }

        else -> {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement =
                    Arrangement.spacedBy(10.dp)
            ) {
                items(
                    items = estado.ciudades,
                    key = { ciudad ->
                        ciudad.id
                    }
                ) { ciudad ->

                    FavoritaItem(
                        ciudad = ciudad,
                        onAbrir = {
                            onCiudadClick(ciudad)
                        },
                        onEliminar = {
                            viewModel.eliminarFavorita(
                                ciudad.id
                            )
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun FavoritaItem(
    ciudad: CiudadFavorita,
    onAbrir: () -> Unit,
    onEliminar: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement =
                Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = ciudad.nombre
            )

            if (ciudad.region.isNotBlank()) {
                Text(
                    text = "Región: ${ciudad.region}"
                )
            }

            if (ciudad.pais.isNotBlank()) {
                Text(
                    text = "País: ${ciudad.pais}"
                )
            }

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = onAbrir
            ) {
                Text(
                    text = "Ver clima"
                )
            }

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = onEliminar
            ) {
                Text(
                    text = "Eliminar"
                )
            }
        }
    }
}