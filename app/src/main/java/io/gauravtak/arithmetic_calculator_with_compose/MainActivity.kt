package io.gauravtak.arithmetic_calculator_with_compose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import io.gauravtak.arithmetic_calculator_with_compose.composable_uis.CalculatorUiScreen
import io.gauravtak.arithmetic_calculator_with_compose.ui.theme.CalculatorTheme

class MainActivity : AppCompatActivity() {
    private var viewModel: CalculatorViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = viewModels<CalculatorViewModel>().value

        setContent {
            CalculatorTheme {
                CalculatorUiScreen(viewModel)
            }
        }
    }
}