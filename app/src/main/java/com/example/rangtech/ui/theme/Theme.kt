package com.example.rangtech.ui.theme

import androidx.compose.material3.*
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import com.example.rangtech.ui.Purple200
import com.example.rangtech.ui.Purple500
import com.example.rangtech.ui.Purple700
import com.example.rangtech.ui.Teal200
import com.example.rangtech.ui.Teal700

val DarkColorScheme = darkColorScheme(
    primary = Purple200,
    onPrimary = White,
    primaryContainer = Purple700,
    onPrimaryContainer = Black,
    secondary = Teal200,
    onSecondary = Black,
    secondaryContainer = Teal700,
    onSecondaryContainer = White
)

private val LightColorScheme = lightColorScheme(
    primary = Purple500,
    onPrimary = White,
    primaryContainer = Purple700,
    onPrimaryContainer = Black,
    secondary = Teal200,
    onSecondary = Black,
    secondaryContainer = Teal700,
    onSecondaryContainer = White
)

@Composable
fun MyAppTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}
