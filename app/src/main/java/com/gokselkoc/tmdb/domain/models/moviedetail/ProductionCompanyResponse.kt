package com.gokselkoc.tmdb.domain.models.moviedetail

import com.fasterxml.jackson.annotation.JsonProperty


data class ProductionCompanyResponse(

    @JsonProperty("id")
    val id: String,

    @JsonProperty("logo_path")
    val logoPath: String?,

    @JsonProperty("name")
    val name: String,

    @JsonProperty("origin_country")
    val originCountry: String,
)