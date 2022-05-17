package com.gokselkoc.tmdb.ui.home.adapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SpaceItemDecoration(
    private val left: Int,
    private val top: Int,
    private val right: Int,
    private val bottom: Int,
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State,
    ) {
        outRect.left = this.left
        outRect.right = this.right
        outRect.top = this.top
        outRect.bottom = this.bottom
    }
}