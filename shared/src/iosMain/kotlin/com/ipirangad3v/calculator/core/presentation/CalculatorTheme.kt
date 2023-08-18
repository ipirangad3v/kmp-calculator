package com.ipirangad3v.calculator.core.presentation

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.ipirangad3v.calculator.ui.theme.DarkColorScheme
import com.ipirangad3v.calculator.ui.theme.LightColorScheme
import com.ipirangad3v.calculator.ui.theme.Typography


@Composable
actual fun CalculatorTheme(
    darkTheme: Boolean,
    dynamicColor: Boolean,
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme,
        typography = Typography,
        content = content
    )
}