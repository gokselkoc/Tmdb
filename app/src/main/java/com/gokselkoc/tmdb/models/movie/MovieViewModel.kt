package com.gokselkoc.tmdb.models.movie

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gokselkoc.tmdb.enum.Status
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

    private val _popularMovieRespone = MutableSharedFlow<MovieGeneralResponse>()
    val popularMovieRespone = _popularMovieRespone.asSharedFlow()

    init {
        getPopularMovies(1)
    }


    private fun getPopularMovies(page: Int) {
        Log.e("test", "Bozuk")
        viewModelScope.launch {
            movieRepository.getPopularMovies(page).collect {

                if (it.status == Status.SUCCESS) {
                    it.let {
                        it.data?.let { data -> _popularMovieRespone.emit(data) }
                    }
                } else if (it.status == Status.ERROR) {
                    Log.e("error", it.message.toString())
                }
            }
        }
    }
}


