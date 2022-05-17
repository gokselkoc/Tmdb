package com.gokselkoc.tmdb.domain.models.moviedetail.image

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class MovieImageResponse(

    @JsonProperty("backdrops")
    val backdrops: ArrayList<PosterResponse>,
    @JsonProperty("id")
    val id: Int,
    @JsonProperty("posters")
    val posters: ArrayList<PosterResponse>,
    @JsonProperty("logos")
    val logos: ArrayList<PosterResponse>,
) : Parcelable

