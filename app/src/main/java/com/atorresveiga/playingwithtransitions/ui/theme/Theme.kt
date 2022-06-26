package com.atorresveiga.playingwithtransitions.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

private val DarkColorPalette = darkColors(
    primary = Purple30,
    primaryVariant = Purple50,
    secondary = Pink30
)

private val LightColorPalette = lightColors(
    primary = Purple60,
    primaryVariant = Purple80,
    secondary = Pink50,
    background = Gray5
)

@Composable
fun PlayingWithTransitionsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

@Composable
fun PlayingWithTransitionsThemeWithSurface(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    PlayingWithTransitionsTheme(darkTheme = darkTheme) {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
            content()
        }
    }
}