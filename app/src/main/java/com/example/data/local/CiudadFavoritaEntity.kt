package com.example.climago.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ciudades_favoritas")
data class CiudadFavoritaEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nombre: String,
    val pais: String,
    val latitud: Double,
    val longitud: Double
)