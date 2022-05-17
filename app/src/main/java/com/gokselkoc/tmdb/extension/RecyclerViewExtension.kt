package com.gokselkoc.tmdb.extension

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gokselkoc.tmdb.ui.home.adapter.SpaceItemDecoration

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

@BindingAdapter(
    value = ["spacePaddingStart", "spacePaddingTop", "spacePaddingEnd", "spacePaddingBottom"],
    requireAll = false
)
fun RecyclerView.setSpace(
    spacePaddingStart: Float?,
    spacePaddingEnd: Float?,
    spacePaddingTop: Float?,
    spacePaddingBottom: Float?,
) {

    addItemDecoration(
        SpaceItemDecoration(
            left = spacePaddingStart?.toInt() ?: 0,
            right = spacePaddingEnd?.toInt() ?: 0,
            top = spacePaddingTop?.toInt() ?: 0,
            bottom = spacePaddingBottom?.toInt() ?: 0
        )
    )

}