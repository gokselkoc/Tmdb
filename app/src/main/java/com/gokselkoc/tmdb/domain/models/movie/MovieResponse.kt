package com.gokselkoc.tmdb.domain.models.movie

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class MovieResponse(

    @JsonProperty("id")
    val id: Int,
    @JsonProperty("poster_path")
    val posterPath: String?,
    @JsonProperty("adult")
    val adult: Boolean,
    @JsonProperty("overview")
    val overview: String,
    @JsonProperty("release_date")
    val releaseDate: String,
    @JsonProperty("genre_ids")
    val genreIds: List<Int>,
    @JsonProperty("original_title")
    val originalTitle: String,
    @JsonProperty("original_language")
    val originalLanguage: String,
    @JsonProperty("title")
    val title: String,
    @JsonProperty("backdrop_path")
    val backDropPath: String?,
    @JsonProperty("popularity")
    val popularity: Double,
    @JsonProperty("vote_count")
    val voteCount: Int,
    @JsonProperty("video")
    val video: Boolean,
    @JsonProperty("vote_average")
    val voteAverage: Double,

    ) : Parcelable