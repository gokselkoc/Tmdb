package com.gokselkoc.tmdb.domain.models.moviedetail.trailer

import com.fasterxml.jackson.annotation.JsonProperty

data class MovieTrailerResponse(

    @JsonProperty("id")
    val id: String,
    @JsonProperty("iso_3166_1")
    val iso_3166_1: String,
    @JsonProperty("iso_639_1")
    val iso_639_1: String,
    @JsonProperty("key")
    val key: String,
    @JsonProperty("name")
    val name: String,
    @JsonProperty("official")
    val official: Boolean,
    @JsonProperty("published_at")
    val published_at: String,
    @JsonProperty("site")
    val site: String,
    @JsonProperty("size")
    val size: Int,
    @JsonProperty("type")
    val type: String,
)

fun MovieTrailerResponse.toTrailerUIModel(): TrailerUIModel {
    return TrailerUIModel(
        name = this.name,
        key = this.key
    )
}