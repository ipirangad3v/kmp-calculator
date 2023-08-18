package com.ipirangad3v.calculator.core.presentation

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CalculatorViewModel : ViewModel() {
    private val _state = MutableStateFlow(CalculatorState())
    val state: StateFlow<CalculatorState> = _state

    fun onEvent(event: CalculatorEvent) {
        when (event) {
            CalculatorEvent.DoOperation -> {
                viewModelScope.launch {
                    _state.update {
                        it.copy(display = "1000")
                    }
                }

            }

            else                        -> Unit
        }

    }
}