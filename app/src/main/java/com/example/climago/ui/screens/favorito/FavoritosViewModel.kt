package com.example.climago.ui.screens.favorito

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.climago.domain.repository.ClimaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FavoritosViewModel(
    private val repository: ClimaRepository
) : ViewModel() {

    /*
    |--------------------------------------------------------------------------
    | ESTADO PRIVADO
    |--------------------------------------------------------------------------
    */

    private val _uiState = MutableStateFlow(
        FavoritosUiState(
            cargando = true
        )
    )

    /*
    |--------------------------------------------------------------------------
    | ESTADO PÚBLICO
    |--------------------------------------------------------------------------
    */

    val uiState: StateFlow<FavoritosUiState> =
        _uiState.asStateFlow()

    /*
    |--------------------------------------------------------------------------
    | INICIALIZACIÓN
    |--------------------------------------------------------------------------
    */

    init {
        observarFavoritos()
    }

    /*
    |--------------------------------------------------------------------------
    | OBSERVAR CIUDADES FAVORITAS
    |--------------------------------------------------------------------------
    */

    private fun observarFavoritos() {
        viewModelScope.launch {
            try {
                repository.observarFavoritas()
                    .collect { ciudades ->

                        _uiState.value = FavoritosUiState(
                            cargando = false,
                            ciudades = ciudades,
                            mensajeError = null
                        )
                    }
            } catch (error: Exception) {
                _uiState.value = FavoritosUiState(
                    cargando = false,
                    ciudades = emptyList(),
                    mensajeError = error.message
                        ?: "Error al cargar favoritos."
                )
            }
        }
    }

    /*
    |--------------------------------------------------------------------------
    | ELIMINAR CIUDAD FAVORITA
    |--------------------------------------------------------------------------
    */

    fun eliminarFavorita(id: Int) {
        viewModelScope.launch {
            try {
                repository.eliminarFavorita(id)

                _uiState.value = _uiState.value.copy(
                    mensajeError = null
                )
            } catch (error: Exception) {
                _uiState.value = _uiState.value.copy(
                    cargando = false,
                    mensajeError = error.message
                        ?: "No se pudo eliminar la ciudad."
                )
            }
        }
    }
}