package com.gokselkoc.tmdb.domain.models.moviedetail.usecase

import com.gokselkoc.tmdb.domain.models.moviedetail.trailer.TrailerUIModel
import com.gokselkoc.tmdb.domain.models.moviedetail.trailer.toTrailerUIModel
import com.gokselkoc.tmdb.enum.Status
import com.gokselkoc.tmdb.repositories.movie.MovieRepository
import com.gokselkoc.tmdb.resource.Resource
import kotlinx.coroutines.flow.Flow

import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MovieTrailerUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
) {


    operator fun invoke(movieId: String): Flow<Resource<ArrayList<TrailerUIModel>>> {

        val list = arrayListOf<TrailerUIModel>()

        return movieRepository.getMovieTrailers(movieId = movieId).map {

            if (it.status == Status.SUCCESS) {
                it.data?.results?.forEach { trailer -> list.add(trailer.toTrailerUIModel()) }
                Resource.success(list)
            } else {
                Resource.error("${it.message}", null)
            }
        }
    }
}


