package com.gokselkoc.tmdb.domain.models.moviedetail.trailer


data class TrailerUIModel(
    val name: String,
    val key: String,
) {
    fun getVideoUrl(): String {
        return "https://img.youtube.com/vi/${key}/0.jpg"
    }
}