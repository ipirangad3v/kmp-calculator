package com.ipirangad3v.calculator.core.presentation

data class CalculatorState(
    val displayValue: String = "0",
    val previousValue: String = "",
    val operation: String = "",
)