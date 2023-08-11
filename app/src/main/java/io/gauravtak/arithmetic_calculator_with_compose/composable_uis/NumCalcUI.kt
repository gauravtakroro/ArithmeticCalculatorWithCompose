package io.gauravtak.arithmetic_calculator_with_compose.composable_uis

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.gauravtak.arithmetic_calculator_with_compose.CalculatorViewModel
import io.gauravtak.arithmetic_calculator_with_compose.ui.theme.InputBlack

@Composable
@Preview
fun NumCalcUI(viewModel: CalculatorViewModel? = null) {
    Column(
        modifier = Modifier.fillMaxHeight().background(InputBlack),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        val rowModifier = Modifier
            .fillMaxWidth()
            .weight(0.2f)

        FourButtonCalcRow(
            rowModifier,
            listOf(CalcButtonEnum.AC, CalcButtonEnum.PlusMinus, CalcButtonEnum.Percent, CalcButtonEnum.Divide),
            viewModel
        )

        FourButtonCalcRow(
            rowModifier,
            listOf(CalcButtonEnum.Seven, CalcButtonEnum.Eight, CalcButtonEnum.Nine, CalcButtonEnum.Multiply),
            viewModel
        )

        FourButtonCalcRow(
            rowModifier,
            listOf(CalcButtonEnum.Four, CalcButtonEnum.Five, CalcButtonEnum.Six, CalcButtonEnum.Minus),
            viewModel
        )

        FourButtonCalcRow(
            rowModifier,
            listOf(CalcButtonEnum.One, CalcButtonEnum.Two, CalcButtonEnum.Three, CalcButtonEnum.Plus),
            viewModel
        )

        Row(
            modifier = rowModifier,
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(0.25f)) {
                CalcButtonUI(
                    CalcButtonEnum.Zero,
                    viewModel
                )
            }

            Column(modifier = Modifier.weight(0.25f)) {
                CalcButtonUI(
                    CalcButtonEnum.Decimal,
                    viewModel
                )
            }

            Column(modifier = Modifier.weight(0.5f)) {
                CalcButtonUI(
                    CalcButtonEnum.Equals,
                    viewModel
                )
            }
        }
    }
}