package com.example.climago.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.climago.data.local.entity.CiudadFavoritaEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CiudadFavoritaDao {

    @Query(
        "SELECT * FROM ciudades_favoritas " +
                "ORDER BY nombre ASC"
    )
    fun observarFavoritas():
            Flow<List<CiudadFavoritaEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun guardar(
        ciudad: CiudadFavoritaEntity
    )

    @Query(
        "DELETE FROM ciudades_favoritas " +
                "WHERE id = :id"
    )
    suspend fun eliminarPorId(id: Int)

    @Query(
        "SELECT EXISTS(" +
                "SELECT 1 FROM ciudades_favoritas " +
                "WHERE latitud = :latitud " +
                "AND longitud = :longitud" +
                ")"
    )
    fun observarEsFavorita(
        latitud: Double,
        longitud: Double
    ): Flow<Boolean>

    @Query(
        "DELETE FROM ciudades_favoritas " +
                "WHERE latitud = :latitud " +
                "AND longitud = :longitud"
    )
    suspend fun eliminarPorCoordenadas(
        latitud: Double,
        longitud: Double
    )
}