package com.gokselkoc.tmdb.domain.models.moviedetail.image

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonProperty
import com.gokselkoc.tmdb.constants.Urls
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class PosterResponse(

    @JsonProperty("aspect_ratio")
    val aspectRatio: Double,
    @JsonProperty("file_path")
    val filePath: String,
    @JsonProperty("height")
    val height: Int,
    @JsonProperty("iso_639_1")
    val iso6391: String?,
    @JsonProperty("vote_average")
    val voteAverage: Double,
    @JsonProperty("vote_count")
    val voteCount: Int,
    @JsonProperty("width")
    val width: Int,
) : Parcelable

fun PosterResponse.toImageUIModel(): ImageUIModel {

    return ImageUIModel(
        imageUrl = Urls.BASE_IMAGE_URL + this.filePath,
        aspectRatio = this.aspectRatio
    )
}