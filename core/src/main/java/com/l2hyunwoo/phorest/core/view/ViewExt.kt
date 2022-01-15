package com.l2hyunwoo.phorest.core.view

import android.os.Handler
import android.os.Looper
import android.view.View

/*
* Created By Nunu Lee
* at 2022.01.15
* */
inline fun View.setOnSingleClickListener(
    delay: Long = 500L,
    crossinline block: (View) -> Unit
) {
    var previousClickedTime = 0L
    setOnClickListener { view ->
        val clickedTime = System.currentTimeMillis()
        if (clickedTime - previousClickedTime >= delay) {
            block(view)
            previousClickedTime = clickedTime
        }
    }
}

interface DoubleClickListener {
    fun onSingleClick(view: View)
    fun onDoubleClick(view: View)
}

class DoubleClick(
    private val doubleClickListener: DoubleClickListener,
    private var DOUBLE_CLICK_INTERVAL: Long = 200L
) : View.OnClickListener {
    private val handler: Handler = Handler(Looper.getMainLooper())
    private var clicks = 0
    private var isBusy = false

    override fun onClick(view: View) {
        if (!isBusy) {
            isBusy = true
            clicks++
            handler.postDelayed({
                if (clicks >= 2) {  // Double tap.
                    doubleClickListener.onDoubleClick(view)
                }
                if (clicks == 1) {  // Single tap
                    doubleClickListener.onSingleClick(view)
                }

                // we need to  restore clicks count
                clicks = 0
            }, DOUBLE_CLICK_INTERVAL)
            isBusy = false
        }
    }
}

