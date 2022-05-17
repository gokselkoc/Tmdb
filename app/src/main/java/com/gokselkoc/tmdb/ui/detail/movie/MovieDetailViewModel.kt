package com.gokselkoc.tmdb.ui.detail.movie

import android.util.Log
import androidx.lifecycle.*
import com.gokselkoc.tmdb.application.TmdbApp
import com.gokselkoc.tmdb.enum.Status
import com.gokselkoc.tmdb.domain.models.moviedetail.MovieDetailResponse
import com.gokselkoc.tmdb.domain.models.moviedetail.image.ImageUIModel
import com.gokselkoc.tmdb.domain.models.moviedetail.usecase.MovieTrailerUseCase
import com.gokselkoc.tmdb.domain.models.moviedetail.trailer.TrailerUIModel
import com.gokselkoc.tmdb.domain.models.moviedetail.usecase.MovieImageUseCase
import com.gokselkoc.tmdb.repositories.movie.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val movieRepository: MovieRepository,
    private val movieTrailerUseCase: MovieTrailerUseCase,
    private val movieImageUseCase: MovieImageUseCase,
) : ViewModel() {


    init {
        getMovieTrailers()
        getMovieDetail()
        getMovieImages()
    }

    private val _movieDetailResponse = MutableLiveData<MovieDetailResponse>()
    val movieDetailResponse: LiveData<MovieDetailResponse> = _movieDetailResponse

    private val _movieTrailerResponse = MutableLiveData<ArrayList<TrailerUIModel>>()
    val movieTrailerResponse: LiveData<ArrayList<TrailerUIModel>> = _movieTrailerResponse

    private val _movieImageResponse = MutableLiveData<ArrayList<ImageUIModel>>()
    val movieImageResponse: LiveData<ArrayList<ImageUIModel>> = _movieImageResponse

    private val _clickedTrailer = MutableLiveData<TrailerUIModel>()
    val clickedTrailer: LiveData<TrailerUIModel> = _clickedTrailer


    private fun getMovieDetail() {

        viewModelScope.launch {
            movieRepository.getMovieDetail(TmdbApp.clickedMovieId.toString()).collect { it ->

                if (it.status == Status.SUCCESS) {
                    it.data?.let { data ->
                        _movieDetailResponse.value = data
                    }
                } else if (it.status == Status.ERROR) {
                    Log.e("error", it.message.toString())
                }
            }
        }
    }


    private fun getMovieTrailers() {

        viewModelScope.launch {
            movieTrailerUseCase.invoke(TmdbApp.clickedMovieId.toString()).collect {
                if (it.status == Status.SUCCESS) {
                    it.data?.let { trailerList ->
                        _movieTrailerResponse.value = trailerList
                    }
                } else if (it.status == Status.ERROR) {
                    Log.e("error", it.message.toString())
                }
            }
        }
    }

    private fun getMovieImages() {

        viewModelScope.launch {
            movieImageUseCase.invoke(TmdbApp.clickedMovieId.toString()).collect {

                if (it.status == Status.SUCCESS) {
                    it.data?.let { imageList ->
                        _movieImageResponse.value = imageList
                    }
                } else if (it.status == Status.ERROR) {
                    Log.e("error Get Movie Image", it.message.toString())
                }
            }
        }
    }


    fun clickedTrailer(data: TrailerUIModel) {
        _clickedTrailer.value = data
    }

}