package io.gauravtak.arithmetic_calculator_with_compose.composable_uis

import androidx.compose.ui.graphics.Color
import io.gauravtak.arithmetic_calculator_with_compose.ui.theme.LightBlack
import io.gauravtak.arithmetic_calculator_with_compose.ui.theme.LightGray
import io.gauravtak.arithmetic_calculator_with_compose.ui.theme.OperatorBlue

enum class CalcButtonEnum(
    val buttonText: String,
    val backgroundColor: Color,
    val expressionValue: String = buttonText
) {
    AC("AC", LightGray),
    PlusMinus("+/-", LightGray),
    Percent("%", LightGray),
    Divide("÷", OperatorBlue, "/"),
    Seven("7", LightBlack),
    Eight("8", LightBlack),
    Nine("9", LightBlack),
    Multiply("x", OperatorBlue, "*"),
    Four("4", LightBlack),
    Five("5", LightBlack),
    Six("6", LightBlack),
    Minus("-", OperatorBlue),
    One("1", LightBlack),
    Two("2", LightBlack),
    Three("3", LightBlack),
    Plus("+", OperatorBlue),
    Zero("0", LightBlack),
    Decimal(".", LightBlack),
    Equals("=", OperatorBlue)
}