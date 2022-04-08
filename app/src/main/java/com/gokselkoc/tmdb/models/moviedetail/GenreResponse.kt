package com.gokselkoc.tmdb.models.moviedetail


import com.fasterxml.jackson.annotation.JsonProperty

data class GenreResponse(

    @JsonProperty("id")
    val id: String,

    @JsonProperty("name")
    val name: String,
)