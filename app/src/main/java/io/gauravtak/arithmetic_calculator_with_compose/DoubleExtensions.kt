package io.gauravtak.arithmetic_calculator_with_compose

import kotlin.math.ceil
import kotlin.math.floor

fun Double.ridZero() : String {
    val intValue = this.toInt()
    val floorValue = floor(this).toInt()
    val ceilValue = ceil(this).toInt()
    if (floorValue == ceilValue && intValue == floorValue) {
        return intValue.toString()
    }
    return this.toString()
}