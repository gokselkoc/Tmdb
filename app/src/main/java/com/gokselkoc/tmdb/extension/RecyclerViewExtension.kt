package com.gokselkoc.tmdb.extension

import androidx.recyclerview.widget.RecyclerView


fun RecyclerView.scrollEndListener(scrollEndFunction: () -> Unit) {
    addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

            if (!recyclerView.canScrollHorizontally(1)) {
                scrollEndFunction.invoke()
            }
        }
    })
}