package com.example.climago.ui.screens.favorito

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.climago.domain.repository.ClimaRepository

class FavoritosViewModelFactory(
    private val repository: ClimaRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {

        if (
            modelClass.isAssignableFrom(
                FavoritosViewModel::class.java
            )
        ) {
            @Suppress("UNCHECKED_CAST")
            return FavoritosViewModel(
                repository = repository
            ) as T
        }

        throw IllegalArgumentException(
            "ViewModel desconocido: ${modelClass.name}"
        )
    }
}