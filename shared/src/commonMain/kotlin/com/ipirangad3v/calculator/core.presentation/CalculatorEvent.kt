package com.ipirangad3v.calculator.core.presentation

sealed interface CalculatorEvent {
    object DoOperation : CalculatorEvent
    data class OnKeyPressed(val key: String) : CalculatorEvent
}