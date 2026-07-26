package com.example.climago.ui.screens.busqueda

import com.example.climago.domain.model.Ciudad

sealed interface BusquedaUiState {

    data object Inicial : BusquedaUiState

    data object Cargando : BusquedaUiState

    data class Exito(
        val ciudades: List<Ciudad>
    ) : BusquedaUiState

    data class Error(
        val mensaje: String
    ) : BusquedaUiState
}