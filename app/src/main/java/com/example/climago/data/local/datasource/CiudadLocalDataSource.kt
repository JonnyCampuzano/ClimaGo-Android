package com.example.climago.data.local.datasource

import com.example.climago.data.local.dao.CiudadFavoritaDao
import com.example.climago.data.local.entity.CiudadFavoritaEntity
import kotlinx.coroutines.flow.Flow

class CiudadLocalDataSource(
    private val dao: CiudadFavoritaDao
) {
    fun observarFavoritas():
            Flow<List<CiudadFavoritaEntity>> {
        return dao.observarFavoritas()
    }

    fun observarEsFavorita(
        latitud: Double,
        longitud: Double
    ): Flow<Boolean> {
        return dao.observarEsFavorita(
            latitud = latitud,
            longitud = longitud
        )
    }

    suspend fun guardar(
        ciudad: CiudadFavoritaEntity
    ) {
        dao.guardar(ciudad)
    }

    suspend fun eliminarPorId(id: Int) {
        dao.eliminarPorId(id)
    }

    suspend fun eliminarPorCoordenadas(
        latitud: Double,
        longitud: Double
    ) {
        dao.eliminarPorCoordenadas(
            latitud = latitud,
            longitud = longitud
        )
    }
}