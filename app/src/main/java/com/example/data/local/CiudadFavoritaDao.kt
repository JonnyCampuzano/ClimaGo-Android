package com.example.climago.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CiudadFavoritaDao {

    @Query("SELECT * FROM ciudades_favoritas ORDER BY nombre ASC")
    fun obtenerCiudades(): Flow<List<CiudadFavoritaEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun guardarCiudad(ciudad: CiudadFavoritaEntity)

    @Delete
    suspend fun eliminarCiudad(ciudad: CiudadFavoritaEntity)
}