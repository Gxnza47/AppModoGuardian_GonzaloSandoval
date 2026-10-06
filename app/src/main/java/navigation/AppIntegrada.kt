package com.example.modoguardian_grupomg.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.modoguardian_grupomg.ui.screens.HomeScreen
import com.example.modoguardian_grupomg.ui.screens.MenuPrincipal
import com.example.modoguardian_grupomg.ui.screens.PantallaPrincipal
import com.example.modoguardian_grupomg.ui.screens.PerfilScreen

// App integrada: un menú principal que lleva a cada una de las guías
@Composable
fun AppIntegrada() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "menu") {

        composable("menu") {
            MenuPrincipal(onNavegar = { ruta -> navController.navigate(ruta) })
        }

        // Guía 9: diseño adaptable (compacta, mediana, expandida)
        composable("guia9") { HomeScreen() }

        // Guía 10: navegación con menú lateral y barra inferior
        composable("guia10") { NavegacionGuia10() }

        // Guía 11: formulario con validaciones y resumen
        composable("guia11") {
            Scaffold { innerPadding ->
                Box(modifier = Modifier.padding(innerPadding)) { AppNavigation() }
            }
        }

        // Guía 12: estado, DataStore y animaciones
        composable("guia12") {
            Scaffold { innerPadding ->
                PantallaPrincipal(modifier = Modifier.padding(innerPadding))
            }
        }

        // Guía 13: cámara y galería
        composable("guia13") {
            Scaffold { innerPadding ->
                PerfilScreen(modifier = Modifier.padding(innerPadding))
            }
        }
    }
}