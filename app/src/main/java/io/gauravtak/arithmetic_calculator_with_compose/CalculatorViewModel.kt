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
    // this is used to show the result value and show output what we tapped with calc buttons
    private var expressionOfCalculations = MutableLiveData("")
    // this is used to show the complete expressions value of calculations and show output what we tapped with calc buttons, numbers buttons  etc.

    private val _slightDelay = 300L /* 300ms for smoothness of calculations,
     this delay has been added because postValue is async  process,
     to get smooth or updated results  slight  delay could be good*/

    private val _logTag = "DidTap"

    fun getCurrentExpression(): MutableLiveData<String> {
        return expressionOfCalculations
    }

    fun getResult(): MutableLiveData<String> {
        return resultValueDisplayed
    }

    fun didTapEqualOperator() {
        if (!this.isArithmeticOperationButtonTapped  || !isResultNotContainsArithmeticOperatorSymbol()) {
            return // don't perform any calculations if no Arithmetic Operation Button Tapped
        }
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
        if (resultValueDisplayed.value?.isEmpty() == true) {
            return
        }
        //didTapPercentOperator
        if (isResultNotContainsArithmeticOperatorSymbol()) {
            resultValueDisplayed.postValue(((resultValueDisplayed.value?.toDouble() ?: 0.0) / 100.0).ridZero())
            PerformOperations.after(_slightDelay) {
                expressionOfCalculations.postValue( "${expressionOfCalculations.value}/100 = ${resultValueDisplayed.value}")
            }
        }
    }

    fun didTapPlusMinusSign() {
        if (resultValueDisplayed.value?.isEmpty() == true) {
            return
        }
        // didTapPlusMinusSign
        if (isResultNotContainsArithmeticOperatorSymbol()) {
            val valueBeforeNegative = resultValueDisplayed.value?.toDouble() ?: 0.0
            resultValueDisplayed.postValue((valueBeforeNegative * -1).ridZero())
            PerformOperations.after(_slightDelay) {
                expressionOfCalculations.postValue( "${expressionOfCalculations.value}x-1 = ${resultValueDisplayed.value}")
            }
        }
    }

    fun didTapClearExpression() {
        // didTapClearExpression
        resultValueDisplayed.postValue("0")
        expressionOfCalculations.postValue("")
        isArithmeticOperationButtonTapped = false
    }

    fun didTapDecimalOperator() {
        // didTapDecimalOperator
        if (isResultNotContainsArithmeticOperatorSymbol()) {
            if (resultValueDisplayed.value?.contains(".") == true) {
                // don't do anything
            } else {
                resultValueDisplayed.postValue("${resultValueDisplayed.value}.")
                expressionOfCalculations.postValue("${expressionOfCalculations.value}.")
            }
        } else {
            resultValueDisplayed.postValue( ".")
            expressionOfCalculations.postValue( "${expressionOfCalculations.value}.")
        }
    }

    fun didTapNumberValue(button: CalcButtonEnum) {
        //  code for numbers
        val number = button.expressionValue
        if (isArithmeticOperationButtonTapped) {
            if (isResultNotContainsArithmeticOperatorSymbol()) {
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
        if (resultValueDisplayed.value?.isEmpty() == true) {
            return
        }

        if (isArithmeticOperationButtonTapped && isResultNotContainsArithmeticOperatorSymbol()) {
            didTapEqualOperator() // perform Equal Operation First, if two consecutive Arithmetic operator tapped
            return
        }

        val slightDelayBetweenTwoOperations: Long = if (isArithmeticOperationButtonTapped && !isResultNotContainsArithmeticOperatorSymbol()) {
            if (button == this.currentArithmeticOperation) {
                return  // no code required because same operator button tapped twice or multiple times
            }
            this.resultValueDisplayed.postValue(this.runningNumberValue.ridZero())
            // remove last element of string (as expressionOfCalculations)
            this.expressionOfCalculations.postValue(this.expressionOfCalculations.value?.dropLast(1))
            300L
        } else {
            0L
        }
        PerformOperations.after(slightDelayBetweenTwoOperations) {
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

    private fun isResultNotContainsArithmeticOperatorSymbol() : Boolean {
        return resultValueDisplayed.value != "+" && resultValueDisplayed.value != "-" && resultValueDisplayed.value != "/" && resultValueDisplayed.value != "x" && resultValueDisplayed.value != "÷"
    }
}