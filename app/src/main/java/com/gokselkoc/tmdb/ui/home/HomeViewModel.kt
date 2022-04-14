package com.gokselkoc.tmdb.ui.home

import android.util.Log
import androidx.lifecycle.*
import com.gokselkoc.tmdb.enum.Status
import com.gokselkoc.tmdb.models.movie.MovieResponse
import com.gokselkoc.tmdb.repositories.movie.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class HomeViewModel
@Inject constructor(private val movieRepository: MovieRepository) : ViewModel() {

    private var _popularMoviePage = 0

    private val _popularMovieResponse = MutableLiveData<ArrayList<MovieResponse>>()
    val popularMovieResponse: LiveData<ArrayList<MovieResponse>> = _popularMovieResponse

    private val _onClickedItemLiveData = MutableLiveData<MovieResponse>()
    val onClickedItemLiveData = _onClickedItemLiveData

    init {
        getPopularMovies()
    }

    fun onClickedItem(data: MovieResponse) {
        _onClickedItemLiveData.value = data
    }

    private fun getPopularMovies() {
        _popularMoviePage++
        viewModelScope.launch {
            movieRepository.getPopularMovies(_popularMoviePage).collect {
                if (it.status == Status.SUCCESS) {
                    it.let {
                        it.data?.let { data ->
                            _popularMovieResponse.value = data.results
                        }
                    }
                } else if (it.status == Status.ERROR) {
                    Log.e("error", it.message.toString())
                }
            }

        }
    }

    fun addNewItemsPopularMovies() {
        getPopularMovies()
    }
}


