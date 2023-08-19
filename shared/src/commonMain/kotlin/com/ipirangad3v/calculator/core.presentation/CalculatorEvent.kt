package com.ipirangad3v.calculator.core.presentation

sealed interface CalculatorEvent {
    data class OnKeyPressed(val key: String) : CalculatorEvent
}