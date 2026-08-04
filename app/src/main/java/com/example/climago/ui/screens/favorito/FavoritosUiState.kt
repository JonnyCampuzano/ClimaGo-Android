package com.example.climago.ui.screens.favorito

import com.example.climago.domain.model.CiudadFavorita

data class FavoritosUiState(
    val cargando: Boolean = true,
    val ciudades: List<CiudadFavorita> =
        emptyList(),
    val mensajeError: String? = null
)