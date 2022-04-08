package com.gokselkoc.tmdb.models.moviedetail

import com.fasterxml.jackson.annotation.JsonProperty


data class ProductionCountryResponse(

    @JsonProperty("iso_3166_1")
    val iso31661: String,

    @JsonProperty("name")
    val name: String,
)