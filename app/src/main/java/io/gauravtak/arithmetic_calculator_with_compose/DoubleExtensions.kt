package io.gauravtak.arithmetic_calculator_with_compose

import kotlin.math.ceil
import kotlin.math.floor

fun Double.ridZero() : String {
    val intValue = this.toLong()
    val floorValue = floor(this).toLong()
    val ceilValue = ceil(this).toLong()
    if (floorValue == ceilValue && intValue == floorValue) {
        return intValue.toString()
    }
    return this.toString()
}