package io.gauravtak.arithmetic_calculator_with_compose.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import io.gauravtak.ArithmeticCalculatorWithCompose.R

val LatoBold = FontFamily(Font(R.font.lato_bold))
val LatoRegular = FontFamily(Font(R.font.lato_regular))

val Typography = Typography(
    displayMedium = TextStyle(
        fontFamily = LatoBold,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp
    ),
    displayLarge = TextStyle(
        fontFamily = LatoBold,
        fontWeight = FontWeight.Bold,
        fontSize = 90.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = LatoRegular,
        fontWeight = FontWeight.Thin,
        fontSize = 20.sp
    )
)