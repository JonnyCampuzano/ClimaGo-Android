package com.example.climago.ui.screens.detalle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.climago.domain.repository.ClimaRepository

class DetalleViewModelFactory(
    private val repository: ClimaRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {
        if (
            modelClass.isAssignableFrom(
                DetalleViewModel::class.java
            )
        ) {
            return DetalleViewModel(repository) as T
        }

        throw IllegalArgumentException(
            "ViewModel no reconocido"
        )
    }
}