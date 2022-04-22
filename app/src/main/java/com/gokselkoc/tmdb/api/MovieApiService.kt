package com.gokselkoc.tmdb.api

import com.gokselkoc.tmdb.models.movie.MovieGeneralResponse
import com.gokselkoc.tmdb.models.moviedetail.MovieDetailResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page: Int,
    ): MovieGeneralResponse

    @GET("movie/{movieId}")
    suspend fun getMovieDetail(
        @Path("movieId") movieId: String,
    ): MovieDetailResponse

    /*
    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("api_key") apiKey: String?,
        @Query("page") page: Int,
    ): MovieGeneralResponse

    @GET("movie/{movieId}/recommendations")
    suspend fun getRecommendations(
        @Query("api_key") apiKey: String?,
        @Path("movieId") movieId: String,
        @Query("page") page: Int,
    ): MovieGeneralResponse

    @GET("movie/{movieId}/similar")
    suspend fun getSimilarMovies(
        @Query("api_key") apiKey: String?,
        @Path("movieId") movieId: String,
        @Query("page") page: Int,
    ): MovieGeneralResponse*/
}