package io.gauravtak.arithmetic_calculator_with_compose.composable_uis

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.gauravtak.arithmetic_calculator_with_compose.CalculatorViewModel

@Composable
@Preview(device = Devices.PIXEL_4, backgroundColor = 0xFFFFFFFF, showBackground = false)
fun CalculatorUiScreen(viewModel: CalculatorViewModel? = null) {
    val currentExpression = viewModel?.getCurrentExpression()?.observeAsState()?.value
    val result = viewModel?.getResult()?.observeAsState()?.value

    Column(modifier = Modifier.fillMaxHeight().fillMaxWidth().padding(horizontal = 10.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = Modifier.weight(0.33f)) {
            InputAreaUI(currentExpression, result)
        }
        Box(modifier = Modifier.weight(0.66f)) {
            NumCalcUI(viewModel)
        }
    }
}