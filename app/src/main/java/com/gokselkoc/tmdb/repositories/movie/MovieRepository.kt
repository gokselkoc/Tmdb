package com.gokselkoc.tmdb.repositories.movie

import com.gokselkoc.tmdb.models.movie.MovieGeneralResponse
import com.gokselkoc.tmdb.models.moviedetail.MovieDetailResponse
import com.gokselkoc.tmdb.resource.Resource
import kotlinx.coroutines.flow.Flow

interface MovieRepository {


    fun getPopularMovies(page: Int, API_KEY: String?): Flow<Resource<MovieGeneralResponse>>

    //fun getUpcomingMovies(page: Int, API_KEY: String?): Flow<Resource<MovieGeneralResponse>>

    //fun getMovieDetail(movieId: String, API_KEY: String?): Flow<Resource<MovieDetailResponse>>

    //fun getMovieReviews(movieId: String): Flow<Resource<MovieReviewResponse>>

    //fun getMovieTrailers(movieId: String): Flow<Resource<TrailersResponse>>

    //fun getMovieCredits(movieId: String): Flow<Resource<CreditResponse>>

    //fun getMovieImages(movieId: String): Flow<Resource<MovieImageResponse>>

    //fun getMovieExternalIds(movieId: String): Flow<Resource<ExternalIdsResponse>>

    /*fun getRecommendations(
        movieId: String,
        page: Int,
        API_KEY: String?,
    ): Flow<Resource<MovieGeneralResponse>>

    fun getSimilarMovies(
        movieId: String,
        page: Int,
        API_KEY: String?,
    ): Flow<Resource<MovieGeneralResponse>>*/
}