package com.example.climago.ui.screens.detalle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.climago.domain.model.CiudadFavorita
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

    private val _esFavorita =
        MutableStateFlow(false)

    val esFavorita: StateFlow<Boolean> =
        _esFavorita.asStateFlow()

    private var observandoFavorita = false

    fun cargarClima(
        latitud: Double,
        longitud: Double
    ) {
        observarFavorita(
            latitud = latitud,
            longitud = longitud
        )

        viewModelScope.launch {
            _uiState.value =
                DetalleUiState.Cargando

            repository.obtenerClima(
                latitud = latitud,
                longitud = longitud
            ).onSuccess { clima ->
                _uiState.value =
                    DetalleUiState.Exito(clima)
            }.onFailure {
                _uiState.value =
                    DetalleUiState.Error(
                        "No se pudo obtener el clima."
                    )
            }
        }
    }

    private fun observarFavorita(
        latitud: Double,
        longitud: Double
    ) {
        if (observandoFavorita) return
        observandoFavorita = true

        viewModelScope.launch {
            repository.observarEsFavorita(
                latitud = latitud,
                longitud = longitud
            ).collect { favorita ->
                _esFavorita.value = favorita
            }
        }
    }

    fun cambiarFavorita(
        ciudad: CiudadFavorita
    ) {
        viewModelScope.launch {
            if (_esFavorita.value) {
                repository
                    .eliminarFavoritaPorCoordenadas(
                        latitud = ciudad.latitud,
                        longitud = ciudad.longitud
                    )
            } else {
                repository.guardarFavorita(ciudad)
            }
        }
    }
}