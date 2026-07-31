
package com.example.climago.data.preferences.datasource

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.climago.domain.model.PreferenciasUsuario
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(
    name = "preferencias_usuario"
)

class PreferencesDataSource(
    private val context: Context
) {
    private companion object {
        val MODO_OSCURO =
            booleanPreferencesKey("modo_oscuro")

        val USAR_FAHRENHEIT =
            booleanPreferencesKey("usar_fahrenheit")
    }

    val preferencias: Flow<PreferenciasUsuario> =
        context.dataStore.data.map { values ->
            PreferenciasUsuario(
                modoOscuro =
                    values[MODO_OSCURO] ?: false,
                usarFahrenheit =
                    values[USAR_FAHRENHEIT] ?: false
            )
        }

    suspend fun guardarModoOscuro(
        activado: Boolean
    ) {
        context.dataStore.edit { values ->
            values[MODO_OSCURO] = activado
        }
    }

    suspend fun guardarFahrenheit(
        activado: Boolean
    ) {
        context.dataStore.edit { values ->
            values[USAR_FAHRENHEIT] = activado
        }
    }
}