package com.ipirangad3v.calculator.core.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ipirangad3v.calculator.core.presentation.CalculatorEvent.OnKeyPressed

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculatorScreen(
    state: CalculatorState,
    onEvent: (CalculatorEvent) -> Unit,
) {

    Scaffold {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                CalculatorDisplay(state = state)
            }
            CalculatorKeyboard(onKeyPressed = { key ->
                onEvent(OnKeyPressed(key))
            })

        }
    }
}

@Composable
fun CalculatorDisplay(state: CalculatorState) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.End,
    ) {
        Text(
            text = state.displayValue,
            fontSize = 48.sp,
            color = Color.Black
        )
    }

}

@Composable
fun CalculatorKeyboard(
    onKeyPressed: (String) -> Unit,
) {
    val keyboardLayout = listOf(
        listOf("7", "8", "9", "/"),
        listOf("4", "5", "6", "*"),
        listOf("1", "2", "3", "-"),
        listOf("0", ".", "=", "+")
    )

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        val textFieldValue = remember { mutableStateOf(TextFieldValue()) }

        BasicTextField(
            value = textFieldValue.value,
            onValueChange = { newValue ->
                textFieldValue.value = newValue
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            textStyle = TextStyle(fontSize = 24.sp),
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        for (row in keyboardLayout) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                for (key in row) {
                    KeyButton(text = key, onKeyPressed = onKeyPressed)
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun KeyButton(
    text: String,
    onKeyPressed: (String) -> Unit,
) {
    ElevatedButton(
        onClick = { onKeyPressed(text) },
        modifier = Modifier
            .size(64.dp)
            .padding(4.dp),
    ) {
        Text(text = text, fontSize = 20.sp, color = Color.Black)
    }
}
