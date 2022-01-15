package com.l2hyunwoo.phorest.presentation.gallery.util

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class FeedGridItemDecoration(
    private val padding: Int
) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        with(outRect) {
            top = padding
            left = padding
            right = padding
            bottom = padding
        }
    }
}