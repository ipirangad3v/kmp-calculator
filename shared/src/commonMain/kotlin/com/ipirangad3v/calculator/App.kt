package com.ipirangad3v.calculator

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.ipirangad3v.calculator.core.presentation.CalculatorScreen
import com.ipirangad3v.calculator.core.presentation.CalculatorTheme
import com.ipirangad3v.calculator.core.presentation.CalculatorViewModel
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory

@Composable
fun App(
    darkTheme: Boolean,
    dynamicColor: Boolean,
) {
    CalculatorTheme(
        darkTheme = darkTheme,
        dynamicColor = dynamicColor
    ) {
        val viewModel = getViewModel(
            key = "calculator-screen",
            factory = viewModelFactory {
                CalculatorViewModel()
            }
        )
        val state by viewModel.state.collectAsState()
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            CalculatorScreen(
                state = state,
                onEvent = viewModel::onEvent,
            )
        }
    }
}