package com.gokselkoc.tmdb.models.tvshows

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class TvShowsResponse(

    @JsonProperty("id")
    val id: Int,
    @JsonProperty("poster_path")
    val posterPath: String?,
    @JsonProperty("popularity")
    val popularity: Double,
    @JsonProperty("backdrop_path")
    val backdropPath: String?,
    @JsonProperty("vote_average")
    val voteAverage: Double,
    @JsonProperty("overview")
    val overview: String,
    @JsonProperty("first_air_date")
    val firstAirDate: String,
    @JsonProperty("origin_country")
    val originCountry: ArrayList<String>,
    @JsonProperty("genre_ids")
    val genreIds: ArrayList<Int>,
    @JsonProperty("original_language")
    val originalLanguage: String,
    @JsonProperty("vote_count")
    val voteCount: Int,
    @JsonProperty("name")
    val name: String,
    @JsonProperty("original_name")
    val originalName: String,

    ) : Parcelable
