package com.gokselkoc.tmdb.repositories.movie

import com.gokselkoc.tmdb.domain.models.moviedetail.trailer.MovieTrailersResponse
import com.gokselkoc.tmdb.domain.models.movie.MovieGeneralResponse
import com.gokselkoc.tmdb.domain.models.moviedetail.MovieDetailResponse
import com.gokselkoc.tmdb.domain.models.moviedetail.image.MovieImageResponse
import com.gokselkoc.tmdb.resource.Resource
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    fun getPopularMovies(page: Int): Flow<Resource<MovieGeneralResponse>>

    fun getMovieDetail(movieId: String): Flow<Resource<MovieDetailResponse>>

    fun getUpcomingMovies(page: Int): Flow<Resource<MovieGeneralResponse>>

    fun getMovieTrailers(movieId: String): Flow<Resource<MovieTrailersResponse>>

    fun getMovieImages(movieId: String): Flow<Resource<MovieImageResponse>>

    //fun getMovieReviews(movieId: String): Flow<Resource<MovieReviewResponse>>

    //fun getMovieCredits(movieId: String): Flow<Resource<CreditResponse>>


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