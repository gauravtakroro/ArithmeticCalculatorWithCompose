package io.gauravtak.arithmetic_calculator_with_compose.composable_uis

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import io.gauravtak.arithmetic_calculator_with_compose.CalculatorViewModel

@Composable
@Preview(device = Devices.PIXEL_4, backgroundColor = 0xFFFFFFFF, showBackground = false)
fun CalculatorUiScreen(viewModel: CalculatorViewModel? = null) {
    val currentExpression = viewModel?.getCurrentExpression()?.observeAsState()?.value
    val result = viewModel?.getResult()?.observeAsState()?.value

    Column(modifier = Modifier.fillMaxHeight()) {
        Box(modifier = Modifier.weight(0.33f)) {
            InputAreaUI(currentExpression, result)
        }
        Box(modifier = Modifier.weight(0.66f)) {
            NumCalcUI(viewModel)
        }
    }
}