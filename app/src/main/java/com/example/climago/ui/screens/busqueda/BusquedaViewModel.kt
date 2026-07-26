package com.example.climago.ui.screens.busqueda

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.climago.domain.repository.ClimaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BusquedaViewModel(
    private val repository: ClimaRepository
) : ViewModel() {

    private val _textoBusqueda = MutableStateFlow("")
    val textoBusqueda: StateFlow<String> =
        _textoBusqueda.asStateFlow()

    private val _uiState =
        MutableStateFlow<BusquedaUiState>(
            BusquedaUiState.Inicial
        )

    val uiState: StateFlow<BusquedaUiState> =
        _uiState.asStateFlow()

    fun actualizarTexto(nuevoTexto: String) {
        _textoBusqueda.value = nuevoTexto
    }

    fun buscarCiudades() {
        val nombre = _textoBusqueda.value.trim()

        if (nombre.length < 2) {
            _uiState.value = BusquedaUiState.Error(
                "Escribe al menos dos letras"
            )
            return
        }

        viewModelScope.launch {
            _uiState.value = BusquedaUiState.Cargando

            repository.buscarCiudades(nombre)
                .onSuccess { ciudades ->
                    _uiState.value = BusquedaUiState.Exito(
                        ciudades = ciudades
                    )
                }
                .onFailure {
                    _uiState.value = BusquedaUiState.Error(
                        mensaje =
                            "No se pudo buscar la ciudad. " +
                                    "Verifica tu conexión."
                    )
                }
        }
    }
}