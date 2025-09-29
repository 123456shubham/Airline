package org.shubham.airline.ui.theme


import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.runtime.CompositionLocalProvider

val LocalAppColors = staticCompositionLocalOf { LightThemeColors }

@Composable
fun AirlineTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkThemeColors else LightThemeColors

    CompositionLocalProvider(LocalAppColors provides colors) {
        content()
    }
}
