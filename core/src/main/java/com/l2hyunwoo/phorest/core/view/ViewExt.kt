package com.l2hyunwoo.phorest.core.view

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
