package io.gauravtak.arithmetic_calculator_with_compose.composable_uis

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import io.gauravtak.arithmetic_calculator_with_compose.CalculatorViewModel

@Composable
fun FourButtonCalcRow(
    modifier: Modifier = Modifier,
    rowElements: List<CalcButtonEnum> = listOf(
        CalcButtonEnum.AC,
        CalcButtonEnum.PlusMinus,
        CalcButtonEnum.Percent,
        CalcButtonEnum.Divide
    ),
    viewModel: CalculatorViewModel?
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (rowElement in rowElements) {
            Column(modifier = Modifier.weight(0.25f)) {
                CalcButtonUI(
                    rowElement,
                    viewModel
                )
            }
        }
    }
}