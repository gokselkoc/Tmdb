package com.gokselkoc.tmdb.domain.models.moviedetail.trailer

import com.fasterxml.jackson.annotation.JsonProperty

data class MovieTrailersResponse(

    @JsonProperty("id")
    val id: Int,
    @JsonProperty("results")
    val results: ArrayList<MovieTrailerResponse>,
)

