package com.gokselkoc.tmdb.domain.models.moviedetail.usecase

import com.gokselkoc.tmdb.domain.models.moviedetail.image.ImageUIModel
import com.gokselkoc.tmdb.domain.models.moviedetail.image.toImageUIModel
import com.gokselkoc.tmdb.enum.Status
import com.gokselkoc.tmdb.repositories.movie.MovieRepository
import com.gokselkoc.tmdb.resource.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MovieImageUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
) {

    operator fun invoke(movieId: String): Flow<Resource<ArrayList<ImageUIModel>>> {

        var list = arrayListOf<ImageUIModel>()

        return movieRepository.getMovieImages(movieId = movieId).map { it ->


            if (it.status == Status.SUCCESS) {
                it.data?.posters?.forEach { image ->
                    list.add(image.toImageUIModel())

                }

                it.data?.backdrops?.forEach { image ->

                    list.add(image.toImageUIModel())
                }

                it.data?.logos?.forEach { image ->
                    list.add(image.toImageUIModel())

                }

                list = ArrayList(list.filter { image -> image.imageUrl.isNotBlank() })
                list.sortBy { image -> image.imageUrl }
                Resource.success(list)
            } else {
                Resource.error("${it.message}", null)
            }
        }
    }
}