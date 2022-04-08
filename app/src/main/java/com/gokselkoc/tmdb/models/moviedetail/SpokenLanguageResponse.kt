package com.gokselkoc.tmdb.models.moviedetail


import com.fasterxml.jackson.annotation.JsonProperty

data class SpokenLanguageResponse(

    @JsonProperty("english_name")
    val englishName: String,

    @JsonProperty("iso_639_1")
    val iso6391: String,

    @JsonProperty("name")
    val name: String
)