package com.example.climago.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
                    navController.navigate(Routes.Busqueda.route)
                },
                onFavoritosClick = {
                    navController.navigate(Routes.Favoritos.route)
                },
                onConfiguracionClick = {
                    navController.navigate(Routes.Configuracion.route)
                }
            )
        }

        composable(Routes.Busqueda.route) {
            BusquedaScreen()
        }

        composable(Routes.Detalle.route) {
            DetalleScreen()
        }

        composable(Routes.Favoritos.route) {
            FavoritosScreen()
        }

        composable(Routes.Configuracion.route) {
            ConfiguracionScreen()
        }
    }
}