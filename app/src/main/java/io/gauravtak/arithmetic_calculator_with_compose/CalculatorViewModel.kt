package io.gauravtak.arithmetic_calculator_with_compose

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.gauravtak.arithmetic_calculator_with_compose.composable_uis.CalcButtonEnum

class CalculatorViewModel : ViewModel() {

    private var isArithmeticOperationButtonTapped = false
    private var resultValueDisplayed = MutableLiveData("")
    private var expressionOfCalculations = MutableLiveData("")

    fun getCurrentExpression(): MutableLiveData<String> {
        return expressionOfCalculations
    }

    fun getResult(): MutableLiveData<String> {
        return resultValueDisplayed
    }

    fun didTapEqualOperator() {
      // didTapEqualOperator
    }

    fun didTapPercentOperator() {
        //didTapPercentOperator
    }

    fun didTapPlusMinusSign() {
        // didTapPlusMinusSign
    }

    fun didTapClearExpression() {
        // didTapClearExpression
    }

    fun didTapDecimalOperator() {
        // didTapDecimalOperator
    }

    fun didTapNumberValue(button: CalcButtonEnum) {
        //  code for numbers
        val number = button.expressionValue
        if (isArithmeticOperationButtonTapped) {
            if (resultValueDisplayed.value != "+" && resultValueDisplayed.value != "-" && resultValueDisplayed.value != "/" && resultValueDisplayed.value != "x") {
                resultValueDisplayed.postValue("${resultValueDisplayed.value}${number}")
            } else {
                resultValueDisplayed.postValue(number)
            }
        } else {
            if (resultValueDisplayed.value != "0") {
                resultValueDisplayed.postValue("${resultValueDisplayed.value}${number}")
            } else {
                resultValueDisplayed.postValue(number)
            }
        }
        expressionOfCalculations.postValue("${expressionOfCalculations.value}${number}")

    }

    fun didTapArithmeticOperator(button: CalcButtonEnum) {
        // calculate calculations using Tapped Arithmetic Operator
    }
}