package com.example.climago.ui.screens.configuracion

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.climago.data.preferences.PreferenciasDataStore
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ConfiguracionViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val preferenciasDataStore =
        PreferenciasDataStore(application.applicationContext)

    val modoOscuro: StateFlow<Boolean> =
        preferenciasDataStore.modoOscuro.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(
                stopTimeoutMillis = 5_000
            ),
            initialValue = false
        )

    fun cambiarModoOscuro(
        activado: Boolean
    ) {
        viewModelScope.launch {

            preferenciasDataStore.guardarModoOscuro(
                activado
            )
        }
    }
}