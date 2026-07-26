package com.example.climago.navigation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.climago.ui.screens.busqueda.BusquedaScreen
import com.example.climago.ui.screens.configuracion.ConfiguracionScreen
import com.example.climago.ui.screens.detalle.DetalleScreen
import com.example.climago.ui.screens.favoritos.FavoritosScreen
import com.example.climago.ui.screens.inicio.InicioScreen

@Composable
fun ClimaNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.Inicio.route
    ) {
        composable(Routes.Inicio.route) {
            InicioScreen(
                onBuscarClick = {
                    navController.navigate(
                        Routes.Busqueda.route
                    )
                },
                onFavoritosClick = {
                    navController.navigate(
                        Routes.Favoritos.route
                    )
                },
                onConfiguracionClick = {
                    navController.navigate(
                        Routes.Configuracion.route
                    )
                }
            )
        }

        composable(Routes.Busqueda.route) {
            BusquedaScreen(
                onCiudadClick = { ciudad ->
                    val nombreSeguro =
                        Uri.encode(ciudad.nombre)

                    navController.navigate(
                        Routes.Detalle.crearRuta(
                            nombre = nombreSeguro,
                            latitud = ciudad.latitud,
                            longitud = ciudad.longitud
                        )
                    )
                }
            )
        }

        composable(
            route = Routes.Detalle.route,
            arguments = listOf(
                navArgument("nombre") {
                    type = NavType.StringType
                },
                navArgument("latitud") {
                    type = NavType.StringType
                },
                navArgument("longitud") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->

            val nombre = Uri.decode(
                backStackEntry.arguments
                    ?.getString("nombre")
                    .orEmpty()
            )

            val latitud = backStackEntry.arguments
                ?.getString("latitud")
                ?.toDoubleOrNull()
                ?: 0.0

            val longitud = backStackEntry.arguments
                ?.getString("longitud")
                ?.toDoubleOrNull()
                ?: 0.0

            DetalleScreen(
                nombreCiudad = nombre,
                latitud = latitud,
                longitud = longitud
            )
        }

        composable(Routes.Favoritos.route) {
            FavoritosScreen()
        }

        composable(Routes.Configuracion.route) {
            ConfiguracionScreen()
        }
    }
}