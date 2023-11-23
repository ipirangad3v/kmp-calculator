package com.ipirangad3v.calculator.util

import co.touchlab.kermit.Logger
import com.ipirangad3v.calculator.core.presentation.CalculatorState

fun CalculatorState.calculate(): CalculatorState {
    return try {
        val firstValue = previousValue.toDouble()
        val secondValue = displayValue.toDouble()
        val result = when (operation) {
            "+" -> firstValue + secondValue
            "-" -> firstValue - secondValue
            "*" -> firstValue * secondValue
            "/" -> firstValue / secondValue
            else -> 0.0
        }
        copy(
            displayValue = result.toString(),
            previousValue = "0",
            operation = ""
        )
    } catch (t: Throwable) {
        Logger.e(tag = "CALCULATE()", messageString = t.toString())
        copy(
            displayValue = "0",
            previousValue = "",
            operation = ""
        )
    }
}