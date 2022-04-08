package com.gokselkoc.tmdb.models.moviedetail

import com.fasterxml.jackson.annotation.JsonProperty


data class BelongsToCollectionResponse(

    @JsonProperty("backdrop_path")
    val backdropPath: String?,

    @JsonProperty("id")
    val id: String,

    @JsonProperty("name")
    val name: String,

    @JsonProperty("poster_path")
    val posterPath: String?
)