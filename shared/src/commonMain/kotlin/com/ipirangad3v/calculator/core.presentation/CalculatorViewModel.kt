package com.ipirangad3v.calculator.core.presentation

import com.ipirangad3v.calculator.util.calculate
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CalculatorViewModel : ViewModel() {
    private val _state = MutableStateFlow(CalculatorState())
    val state: StateFlow<CalculatorState> = _state

    fun onEvent(event: CalculatorEvent) {
        when (event) {
            is CalculatorEvent.OnKeyPressed -> {
                when (event.key) {
                    "+", "-", "/", "*" -> {
                        _state.update {
                            it.copy(
                                previousValue = it.displayValue,
                                operation = event.key,
                                displayValue = "0"
                            )
                        }
                    }

                    "AC"               -> {
                        _state.update { CalculatorState() }
                    }

                    "DEL"              -> {
                        _state.update {
                            it.copy(
                                displayValue = if (it.displayValue != "0") it.displayValue.dropLast(
                                    1
                                ) else "0"
                            )
                        }
                    }

                    "="                -> {
                        _state.update { it.calculate() }
                    }

                    else               -> {
                        _state.update { it.copy(displayValue = if (it.displayValue == "0") event.key else it.displayValue + event.key) }
                    }
                }

            }


        }

    }
}