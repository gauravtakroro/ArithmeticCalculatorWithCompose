package io.gauravtak.arithmetic_calculator_with_compose.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun CalculatorTheme(content: @Composable () -> Unit) {

    MaterialTheme(
        typography = Typography, content = content
    )
}