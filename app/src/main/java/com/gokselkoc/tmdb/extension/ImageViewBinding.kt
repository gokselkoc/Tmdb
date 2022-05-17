package com.gokselkoc.tmdb.extension

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.webkit.URLUtil
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.gokselkoc.tmdb.R
import com.gokselkoc.tmdb.constants.Urls

fun ImageView.downLoadView(url: String?, progressDrawable: CircularProgressDrawable) {

    val option = RequestOptions()
        .placeholder(progressDrawable)
        .error(R.drawable.ic_home)

    Glide.with(context)
        .setDefaultRequestOptions(option)
        .load(url)
        .into(this)
}

fun placeHolderProgressBar(context: Context): CircularProgressDrawable {

    return CircularProgressDrawable(context).apply {
        strokeWidth = 8f
        centerRadius = 40f
        setColorSchemeColors(Color.WHITE)
        start()
    }
}

@BindingAdapter("imageUrl")
fun setMovieImage(imageView: ImageView, url: String?) {

    var imageUrl = url
    imageUrl = if (url == null) {
        Urls.DEFAULT_IMAGE_URL
    } else if (URLUtil.isValidUrl(imageUrl)) {
        imageUrl
    } else {
        Urls.BASE_IMAGE_URL + imageUrl
    }

    imageView.downLoadView(url = imageUrl,
        progressDrawable = placeHolderProgressBar(imageView.context))
}



