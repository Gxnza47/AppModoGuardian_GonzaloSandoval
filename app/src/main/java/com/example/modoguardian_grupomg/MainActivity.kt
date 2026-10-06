package com.example.modoguardian_grupomg

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.example.modoguardian_grupomg.ui.screens.PantallaPrincipal
import com.example.modoguardian_grupomg.ui.theme.ModoGuardian_GrupoMGTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            ModoGuardian_GrupoMGTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Aplicamos el padding correcto para la barra de estado y navegación
                    PantallaPrincipal(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}