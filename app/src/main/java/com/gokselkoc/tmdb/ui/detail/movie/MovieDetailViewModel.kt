package com.gokselkoc.tmdb.ui.detail.movie


import android.util.Log
import androidx.lifecycle.*
import com.gokselkoc.tmdb.application.TmdbApp
import com.gokselkoc.tmdb.enum.Status
import com.gokselkoc.tmdb.models.moviedetail.MovieDetailResponse
import com.gokselkoc.tmdb.repositories.movie.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import javax.inject.Inject


@ExperimentalCoroutinesApi
@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val movieRepository: MovieRepository,
) : ViewModel() {


    init {
        getMovieDetailViewModel()

    }

    private val _movieDetailResponse = MutableLiveData<MovieDetailResponse>()
    val movieDetailResponse: LiveData<MovieDetailResponse> = _movieDetailResponse


    private fun getMovieDetailViewModel() {

        viewModelScope.launch {
            movieRepository.getMovieDetail(TmdbApp.clickedMovieId.toString()).collect { it ->

                if (it.status == Status.SUCCESS) {
                    it.data?.let { data ->
                        Log.e("detay", data.genres.count().toString())
                        _movieDetailResponse.value = data
                    }
                } else if (it.status == Status.ERROR) {
                    Log.e("error", it.message.toString())
                }
            }
        }
    }
}