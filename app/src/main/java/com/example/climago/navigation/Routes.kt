package com.example.climago.navigation

sealed class Routes(val route: String) {

    data object Inicio : Routes("inicio")

    data object Busqueda : Routes("busqueda")

    data object Detalle :
        Routes(
            "detalle/{nombre}/{latitud}/{longitud}"
        ) {

        fun crearRuta(
            nombre: String,
            latitud: Double,
            longitud: Double
        ): String {
            return "detalle/$nombre/$latitud/$longitud"
        }
    }

    data object Favoritos : Routes("favoritos")

    data object Configuracion :
        Routes("configuracion")
}