package com.gokselkoc.tmdb.models.tvshows

import com.fasterxml.jackson.annotation.JsonProperty

data class TvShowsGeneralResponse(

    @JsonProperty("page")
    val page: Int?,
    @JsonProperty("results")
    val results: ArrayList<TvShowsResponse>,
    @JsonProperty("total_results")
    val totalResults: Int?,
    @JsonProperty("total_pages")
    val totalPages: Int?,
)
