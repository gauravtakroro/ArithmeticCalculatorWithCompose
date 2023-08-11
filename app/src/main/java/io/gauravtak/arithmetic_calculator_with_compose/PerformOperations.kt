package io.gauravtak.arithmetic_calculator_with_compose

import android.os.Handler
import android.os.Looper

object PerformOperations {
    private var handler: Handler = Handler(Looper.getMainLooper())

    fun after(seconds: Float, work: () -> Unit) {
        after(milliseconds = (seconds * 1000).toLong(), work = work)
    }

    fun after(milliseconds: Long, work: () -> Unit) {
        handler.postDelayed({ work() }, milliseconds)
    }

    fun atEoq(work: () -> Unit) {
        handler.post { work() }
    }
}