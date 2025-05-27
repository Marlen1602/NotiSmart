package com.example.notismart.presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.wear.compose.material.Colors
import androidx.wear.compose.material.MaterialTheme

// Paleta de colores personalizada
private val NotiSmartColorPalette = Colors(
    primary = Color(0xFF5A8DEE),        // Azul principal
    onPrimary = Color.White,            // Texto sobre primario
    secondary = Color(0xFF00BFA5),      // Verde menta
    onSecondary = Color.Black,
    background = Color(0xFF121212),     // Fondo oscuro
    onBackground = Color.Black,
    surface = Color(0xFF1E1E1E),        // Superficies (tarjetas, botones)
    onSurface = Color.Black
)

@Composable
fun NotiSmartTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = NotiSmartColorPalette,
        content = content
    )
}
