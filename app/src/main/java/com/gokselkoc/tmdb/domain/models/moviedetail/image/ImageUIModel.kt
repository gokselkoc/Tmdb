package com.gokselkoc.tmdb.domain.models.moviedetail.image

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class ImageUIModel(
    val imageUrl: String,
    val aspectRatio: Double,
) : Parcelable