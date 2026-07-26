package com.example.climago.ui.screens.busqueda

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.climago.domain.repository.ClimaRepository

class BusquedaViewModelFactory(
    private val repository: ClimaRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {
        if (
            modelClass.isAssignableFrom(
                BusquedaViewModel::class.java
            )
        ) {
            return BusquedaViewModel(repository) as T
        }

        throw IllegalArgumentException(
            "ViewModel no reconocido"
        )
    }
}