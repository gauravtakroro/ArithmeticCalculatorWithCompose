package io.gauravtak.arithmetic_calculator_with_compose

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.gauravtak.arithmetic_calculator_with_compose.composable_uis.CalcButtonEnum

class CalculatorViewModel : ViewModel() {

    private var runningNumberValue = 0.0
    private var currentArithmeticOperation: CalcButtonEnum? = null
    private var isArithmeticOperationButtonTapped = false

    private var resultValueDisplayed = MutableLiveData("")
    private var expressionOfCalculations = MutableLiveData("")

    private val _slightDelay = 300L // 300ms for smoothness of calculations
    private val _logTag = "DidTap"

    fun getCurrentExpression(): MutableLiveData<String> {
        return expressionOfCalculations
    }

    fun getResult(): MutableLiveData<String> {
        return resultValueDisplayed
    }

    fun didTapEqualOperator() {
        // didTapEqualOperator
        val runningValue = runningNumberValue
        val currentValue = resultValueDisplayed.value?.toDouble() ?: 0.0
        isArithmeticOperationButtonTapped = false
        when (currentArithmeticOperation) {
            CalcButtonEnum.Plus -> {
                resultValueDisplayed.postValue((runningValue + currentValue).ridZero())
            }
            CalcButtonEnum.Minus -> {
                resultValueDisplayed.postValue((runningValue - currentValue).ridZero())
            }
            CalcButtonEnum.Multiply -> {
                resultValueDisplayed.postValue((runningValue * currentValue).ridZero())
            }
            CalcButtonEnum.Divide -> {
                resultValueDisplayed.postValue((runningValue / currentValue).ridZero())
            }
            else -> {
                // no code
            }
        }
        PerformOperations.after(_slightDelay) {
            val resultNew = StringBuilder()
            resultNew.append(this.expressionOfCalculations.value)
            resultNew.append("=")
            resultNew.append(this.resultValueDisplayed.value)
            expressionOfCalculations.postValue(resultNew.toString())
            Log.d(_logTag, "${resultValueDisplayed.value} ${expressionOfCalculations.value}")
        }
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
        if (isArithmeticOperationButtonTapped) {
            didTapEqualOperator() // perform Equal Operation First, if two consecutive Arithmetic operator tapped
        }
        // perform calculations using Tapped Arithmetic Operator
        currentArithmeticOperation = button
        runningNumberValue = resultValueDisplayed.value?.toDouble() ?: 0.0
        isArithmeticOperationButtonTapped = true
        val result = StringBuilder()
        result.append(resultValueDisplayed.value)
        result.append(button.buttonText)
        resultValueDisplayed.postValue(result.toString())
        if (expressionOfCalculations.value?.last()
                .toString() != button.buttonText
        ) {
            resultValueDisplayed.postValue(button.buttonText)
            expressionOfCalculations.postValue("${expressionOfCalculations.value}${button.buttonText}")
        }
        PerformOperations.after(_slightDelay) {
            Log.d(_logTag, "${resultValueDisplayed.value} ${expressionOfCalculations.value}")
        }
    }
}