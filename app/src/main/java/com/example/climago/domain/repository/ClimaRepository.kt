package com.example.climago.domain.repository

import com.example.climago.domain.model.Ciudad
import com.example.climago.domain.model.CiudadFavorita
import com.example.climago.domain.model.Clima
import com.example.climago.domain.model.PreferenciasUsuario
import kotlinx.coroutines.flow.Flow

interface ClimaRepository {

    suspend fun buscarCiudades(
        nombre: String
    ): Result<List<Ciudad>>

    suspend fun obtenerClima(
        latitud: Double,
        longitud: Double
    ): Result<Clima>

    fun observarFavoritas():
            Flow<List<CiudadFavorita>>

    fun observarEsFavorita(
        latitud: Double,
        longitud: Double
    ): Flow<Boolean>

    suspend fun guardarFavorita(
        ciudad: CiudadFavorita
    )

    suspend fun eliminarFavorita(
        id: Int
    )

    suspend fun eliminarFavoritaPorCoordenadas(
        latitud: Double,
        longitud: Double
    )

    fun observarPreferencias():
            Flow<PreferenciasUsuario>

    suspend fun cambiarModoOscuro(
        activado: Boolean
    )

    suspend fun cambiarFahrenheit(
        activado: Boolean
    )
}