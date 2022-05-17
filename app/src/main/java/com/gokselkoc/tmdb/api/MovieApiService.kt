package com.gokselkoc.tmdb.api

import com.gokselkoc.tmdb.domain.models.moviedetail.trailer.MovieTrailersResponse
import com.gokselkoc.tmdb.domain.models.movie.MovieGeneralResponse
import com.gokselkoc.tmdb.domain.models.moviedetail.MovieDetailResponse
import com.gokselkoc.tmdb.domain.models.moviedetail.image.MovieImageResponse
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


    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("page") page: Int,
    ): MovieGeneralResponse

    @GET("movie/{movieId}/videos")
    suspend fun getMovieTrailers(
        @Path("movieId") movieId: String,
    ): MovieTrailersResponse


    @GET("movie/{movieId}/images")
    suspend fun getMovieImages(
        @Path("movieId") movieId: String,
    ): MovieImageResponse
    /*
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