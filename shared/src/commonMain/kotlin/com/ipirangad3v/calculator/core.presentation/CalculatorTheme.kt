package com.ipirangad3v.calculator.core.presentation

import androidx.compose.runtime.Composable

@Composable
expect fun CalculatorTheme(
    darkTheme: Boolean = false,
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
)