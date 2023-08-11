package io.gauravtak.arithmetic_calculator_with_compose.composable_uis

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import io.gauravtak.arithmetic_calculator_with_compose.CalculatorViewModel

@Composable
@Preview(heightDp = 80, widthDp = 80)
fun CalcButtonUI(button: CalcButtonEnum = CalcButtonEnum.AC, viewModel: CalculatorViewModel? = null) {
    Box(
        modifier = Modifier
            .background(button.backgroundColor, shape = CircleShape).fillMaxSize(fraction = 0.90f)
            .clickable(onClick = {
                when (button) {
                    CalcButtonEnum.AC -> viewModel?.didTapClearExpression()
                    CalcButtonEnum.PlusMinus -> viewModel?.didTapPlusMinusSign()
                    CalcButtonEnum.Equals -> viewModel?.didTapEqualOperator()
                    CalcButtonEnum.Percent -> viewModel?.didTapPercentOperator()
                    CalcButtonEnum.Decimal -> viewModel?.didTapDecimalOperator()
                    CalcButtonEnum.Plus, CalcButtonEnum.Divide, CalcButtonEnum.Multiply, CalcButtonEnum.Minus ->
                        viewModel?.didTapArithmeticOperator(button)
                    else -> viewModel?.didTapNumberValue(button)
                }
            }),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = button.buttonText,
            color = Color.White,
            style = MaterialTheme.typography.displaySmall
        )
    }
}