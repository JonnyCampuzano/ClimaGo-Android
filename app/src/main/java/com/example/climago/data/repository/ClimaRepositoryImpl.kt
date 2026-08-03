package com.example.climago.data.repository

import com.example.climago.data.mapper.toDomain
import com.example.climago.data.remote.datasource.ClimaRemoteDataSource
import com.example.climago.domain.model.Ciudad
import com.example.climago.domain.model.CiudadFavorita
import com.example.climago.domain.model.Clima
import com.example.climago.domain.model.PreferenciasUsuario
import com.example.climago.domain.repository.ClimaRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flowOf

class ClimaRepositoryImpl(
    private val remoteDataSource: ClimaRemoteDataSource
) : ClimaRepository {

    /*
    |--------------------------------------------------------------------------
    | BUSCAR CIUDADES
    |--------------------------------------------------------------------------
    */

    override suspend fun buscarCiudades(
        nombre: String
    ): Result<List<Ciudad>> {

        return try {
            val nombreLimpio = nombre.trim()

            if (nombreLimpio.isEmpty()) {
                return Result.success(emptyList())
            }

            val respuesta = remoteDataSource.buscarCiudades(
                nombre = nombreLimpio
            )

            val ciudades = respuesta.results
                .orEmpty()
                .map { ciudadDto ->
                    ciudadDto.toDomain()
                }

            Result.success(ciudades)
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }

    /*
    |--------------------------------------------------------------------------
    | OBTENER CLIMA
    |--------------------------------------------------------------------------
    */

    override suspend fun obtenerClima(
        latitud: Double,
        longitud: Double
    ): Result<Clima> {

        return try {
            val respuesta = remoteDataSource.obtenerClima(
                latitud = latitud,
                longitud = longitud
            )

            val clima = respuesta.toDomain()

            Result.success(clima)
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }

    /*
    |--------------------------------------------------------------------------
    | FAVORITOS
    |--------------------------------------------------------------------------
    |
    | Estas implementaciones permiten que el proyecto compile.
    | Después se conectarán con Room.
    |
    */

    override fun observarFavoritas(): Flow<List<CiudadFavorita>> {
        return flowOf(emptyList())
    }

    override fun observarEsFavorita(
        latitud: Double,
        longitud: Double
    ): Flow<Boolean> {
        return flowOf(false)
    }

    override suspend fun guardarFavorita(
        ciudad: CiudadFavorita
    ) {
        // Pendiente: guardar usando Room.
    }

    override suspend fun eliminarFavorita(
        id: Int
    ) {
        // Pendiente: eliminar usando Room.
    }

    override suspend fun eliminarFavoritaPorCoordenadas(
        latitud: Double,
        longitud: Double
    ) {
        // Pendiente: eliminar usando Room.
    }


    override fun observarPreferencias(): Flow<PreferenciasUsuario> {
        return emptyFlow()
    }

    override suspend fun cambiarModoOscuro(
        activado: Boolean
    ) {
        // Pendiente: guardar preferencia usando DataStore.
    }

    override suspend fun cambiarFahrenheit(
        activado: Boolean
    ) {
        // Pendiente: guardar preferencia usando DataStore.
    }
}