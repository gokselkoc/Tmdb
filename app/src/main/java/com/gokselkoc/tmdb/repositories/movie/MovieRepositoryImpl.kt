package com.gokselkoc.tmdb.repositories.movie

import com.gokselkoc.tmdb.api.MovieApiService
import com.gokselkoc.tmdb.base.BaseRepository
import com.gokselkoc.tmdb.models.movie.MovieGeneralResponse
import com.gokselkoc.tmdb.models.moviedetail.MovieDetailResponse
import com.gokselkoc.tmdb.resource.Resource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ExperimentalCoroutinesApi
class MovieRepositoryImpl @Inject constructor(
    private val movieApiService: MovieApiService,
) :
    MovieRepository, BaseRepository() {
    override fun getPopularMovies(page: Int): Flow<Resource<MovieGeneralResponse>> {
        return onApiCall { movieApiService.getPopularMovies(page = page) }
    }

    override fun getMovieDetail(movieId: String): Flow<Resource<MovieDetailResponse>> {
        return onApiCall { movieApiService.getMovieDetail(movieId = movieId) }
    }
}