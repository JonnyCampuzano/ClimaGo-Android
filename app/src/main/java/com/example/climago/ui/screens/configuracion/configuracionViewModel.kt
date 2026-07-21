package com.example.climago.ui.screens.configuracion

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.climago.data.preferences.PreferenciasDataStore
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ConfiguracionViewModel(
    private val preferenciasDataStore: PreferenciasDataStore
) : ViewModel() {

    val modoOscuro = preferenciasDataStore.modoOscuro.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = false
    )

    fun cambiarModoOscuro(activado: Boolean) {
        viewModelScope.launch {
            preferenciasDataStore.guardarModoOscuro(activado)
        }
    }
}