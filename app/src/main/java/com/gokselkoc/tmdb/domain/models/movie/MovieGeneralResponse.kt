package com.gokselkoc.tmdb.domain.models.movie

import com.fasterxml.jackson.annotation.JsonProperty

data class MovieGeneralResponse(

    @JsonProperty("page")
    val page: Int?,
    @JsonProperty("results")
    val results: ArrayList<MovieResponse>,
    @JsonProperty("total_results")
    val totalResults: Int?,
    @JsonProperty("total_pages")
    val totalPages: Int?,
)