package com.gokselkoc.tmdb.ui.home

import android.util.Log
import androidx.lifecycle.*
import com.gokselkoc.tmdb.enum.Status
import com.gokselkoc.tmdb.models.movie.MovieResponse
import com.gokselkoc.tmdb.models.tvshows.TvShowsResponse
import com.gokselkoc.tmdb.repositories.movie.MovieRepository
import com.gokselkoc.tmdb.repositories.tvshows.TvShowsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val movieRepository: MovieRepository,
    private val tvShowsRepository: TvShowsRepository,
) : ViewModel() {


    private var _popularMoviePage = 0

    private val _popularMovieResponse = MutableLiveData<ArrayList<MovieResponse>>()
    val popularMovieResponse: LiveData<ArrayList<MovieResponse>> = _popularMovieResponse

    var allPopularMovieList: ArrayList<MovieResponse> = arrayListOf()

    private val _onClickedItemLiveData = MutableLiveData<MovieResponse>()
    val onClickedItemLiveData = _onClickedItemLiveData

    init {
        getPopularMovies()
        getPopularTvShows()
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

    fun onClickedMovieItem(data: MovieResponse) {
        _onClickedItemLiveData.value = data
    }

    fun addNewItemsPopularMovies() {
        getPopularMovies()
    }

    // End -> Popular Movies

    // Start -> Popular Tv Shows

    private var _popularTvShowsPage = 0

    private var _popularTvShowsResponse = MutableLiveData<ArrayList<TvShowsResponse>>()
    val popularTvShowsResponse: LiveData<ArrayList<TvShowsResponse>> = _popularTvShowsResponse

    var allPopularTvShowsList: ArrayList<TvShowsResponse> = arrayListOf()

    private val _clickedTvShowsItemLiveData = MutableLiveData<TvShowsResponse>()
    val clickedTvShowsItemLiveData = _clickedTvShowsItemLiveData

    private fun getPopularTvShows() {
        _popularTvShowsPage++
        viewModelScope.launch {
            tvShowsRepository.getPopularTvShows(_popularTvShowsPage).collect {
                if (it.status == Status.SUCCESS) {
                    it.let {
                        it.data?.let { data ->
                            _popularTvShowsResponse.value = data.results
                        }
                    }
                } else if (it.status == Status.ERROR) {
                    Log.e("error", it.message.toString())
                }
            }
        }
    }

    fun addNewItemsPopularTvShows() {
        getPopularTvShows()
    }

    fun onClickedTvShowsItem(data: TvShowsResponse) {
        _clickedTvShowsItemLiveData.value = data
    }
}


