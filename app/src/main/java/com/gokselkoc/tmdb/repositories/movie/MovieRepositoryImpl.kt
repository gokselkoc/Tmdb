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
    private val movieApiService: MovieApiService
) :
    MovieRepository,BaseRepository()
{
    override fun getPopularMovies(page: Int,API_KEY :String?): Flow<Resource<MovieGeneralResponse>> {
        return onApiCall { movieApiService.getPopularMovies(apiKey = API_KEY, page = page) }
    }
}