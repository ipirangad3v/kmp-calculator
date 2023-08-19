package com.ipirangad3v.calculator.util

import com.ipirangad3v.calculator.core.presentation.CalculatorState

fun CalculatorState.calculate(): CalculatorState {
    val firstValue = previousValue.toDouble()
    val secondValue = displayValue.toDouble()
    val result = when (operation) {
        "+"  -> firstValue + secondValue
        "-"  -> firstValue - secondValue
        "*"  -> firstValue * secondValue
        "/"  -> firstValue / secondValue
        else -> 0.0
    }
    return copy(
        displayValue = result.toString(),
        previousValue = "0",
        operation = ""
    )
}