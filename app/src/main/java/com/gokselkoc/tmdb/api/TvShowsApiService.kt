package com.gokselkoc.tmdb.api

import com.gokselkoc.tmdb.models.tvshows.TvShowsGeneralResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface TvShowsApiService {

    @GET("tv/popular")
    suspend fun getPopularTvShows(
        @Query("page") page: Int
    ) : TvShowsGeneralResponse
}