package com.example.climago.ui.screens.detalle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.climago.domain.repository.ClimaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetalleViewModel(
    private val repository: ClimaRepository
) : ViewModel() {

    private val _uiState =
        MutableStateFlow<DetalleUiState>(
            DetalleUiState.Cargando
        )

    val uiState: StateFlow<DetalleUiState> =
        _uiState.asStateFlow()

    fun cargarClima(
        latitud: Double,
        longitud: Double
    ) {
        viewModelScope.launch {
            _uiState.value = DetalleUiState.Cargando

            repository.obtenerClima(
                latitud = latitud,
                longitud = longitud
            ).onSuccess { clima ->
                _uiState.value = DetalleUiState.Exito(
                    clima = clima
                )
            }.onFailure {
                _uiState.value = DetalleUiState.Error(
                    mensaje =
                        "No se pudo obtener el clima. " +
                                "Verifica tu conexión."
                )
            }
        }
    }
}