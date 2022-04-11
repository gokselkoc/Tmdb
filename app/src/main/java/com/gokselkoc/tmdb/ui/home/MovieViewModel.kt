package com.gokselkoc.tmdb.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gokselkoc.tmdb.enum.Status
import com.gokselkoc.tmdb.models.movie.MovieGeneralResponse
import com.gokselkoc.tmdb.models.movie.MovieResponse
import com.gokselkoc.tmdb.repositories.movie.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class MovieViewModel
@Inject constructor(private val movieRepository: MovieRepository) : ViewModel() {

    private var _popularMoviePage = 0
    val popularMoviePage = _popularMoviePage

    private val _popularMovieRespons = MutableSharedFlow<MovieGeneralResponse>()
    val popularMovieRespons = _popularMovieRespons.asSharedFlow()

    private val _onClickedItemFlow = MutableSharedFlow<MovieResponse>()
    val onClickedItemFlow = _onClickedItemFlow.asSharedFlow()

    private var _popularMovieCurrentList = arrayListOf<MovieResponse>()
    var popularMovieCurrentList = _popularMovieCurrentList

    init {
        getPopularMovies()

    }

    fun onClickedItem(data: MovieResponse) {
        viewModelScope.launch {
            _onClickedItemFlow.emit(data)
        }
    }

    private fun getPopularMovies() {
        _popularMoviePage++
        viewModelScope.launch {
            movieRepository.getPopularMovies(_popularMoviePage).collect {

                if (it.status == Status.SUCCESS) {
                    it.let {
                        it.data?.let { data ->
                            _popularMovieRespons.emit(data)
                            _popularMovieCurrentList.addAll(data.results)
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


