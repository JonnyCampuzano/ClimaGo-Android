package com.example.climago.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.climago.data.local.entity.CiudadFavoritaEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CiudadFavoritaDao {

    @Query("SELECT * FROM ciudades_favoritas ORDER BY nombre ASC")
    fun obtenerCiudades(): Flow<List<CiudadFavoritaEntity>>

    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun guardarCiudad(ciudad: CiudadFavoritaEntity)

    @Delete
    suspend fun eliminarCiudad(ciudad: CiudadFavoritaEntity)
}