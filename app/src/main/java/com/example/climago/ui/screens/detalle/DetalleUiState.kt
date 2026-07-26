package com.example.climago.ui.screens.detalle

import com.example.climago.domain.model.Clima

sealed interface DetalleUiState {

    data object Cargando : DetalleUiState

    data class Exito(
        val clima: Clima
    ) : DetalleUiState

    data class Error(
        val mensaje: String
    ) : DetalleUiState
}