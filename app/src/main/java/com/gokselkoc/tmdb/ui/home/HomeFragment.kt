package com.gokselkoc.tmdb.ui.home


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.viewModels
import com.gokselkoc.tmdb.R
import com.gokselkoc.tmdb.application.TmdbApp
import com.gokselkoc.tmdb.base.BaseVmDbFragment
import com.gokselkoc.tmdb.constants.Keys
import com.gokselkoc.tmdb.databinding.FragmentHomeBinding
import com.gokselkoc.tmdb.extension.navigateSafe
import com.gokselkoc.tmdb.extension.observe
import com.gokselkoc.tmdb.extension.scrollEndListener
import com.gokselkoc.tmdb.models.movie.MovieResponse
import com.gokselkoc.tmdb.models.tvshows.TvShowsResponse
import com.gokselkoc.tmdb.ui.home.adapter.PopularMoviesAdapter
import com.gokselkoc.tmdb.ui.home.adapter.PopularTvShowsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class HomeFragment : BaseVmDbFragment<FragmentHomeBinding>() {


    private val viewModel by viewModels<HomeViewModel>()


    private val popularMoviesAdapter: PopularMoviesAdapter by lazy {
        PopularMoviesAdapter(
            ArrayList(),
            viewModel

        )
    }

    private val popularTvShowsAdapter: PopularTvShowsAdapter by lazy {
        PopularTvShowsAdapter(
            ArrayList(),
            viewModel
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        observe(viewModel.onClickedItemLiveData, ::clickedPopularMovieItem)
        observe(viewModel.clickedTvShowsItemLiveData, ::clickedPopularTvShowsItem)
    }


    override fun onInitDataBinding() {

        if (popularMoviesAdapter.list.isEmpty() || popularTvShowsAdapter.list.isEmpty()) {

            observe(viewModel.popularMovieResponse, ::homeGetPopularMovies)
            observe(viewModel.popularTvShowsResponse, ::homeGetPopularTvShows)
        }

        viewBinding.popularMovieRecyclerView.adapter = popularMoviesAdapter

        viewBinding.homePopularTvShowsRecyclerView.adapter = popularTvShowsAdapter

        viewBinding.popularMovieRecyclerView.scrollEndListener {
            viewModel.addNewItemsPopularMovies()
        }

        viewBinding.homePopularTvShowsRecyclerView.scrollEndListener {
            viewModel.addNewItemsPopularTvShows()
        }
    }

    private fun homeGetPopularMovies(movieResponseList: ArrayList<MovieResponse>) {
        popularMoviesAdapter.addToAdapter(movieResponseList)
    }

    private fun homeGetPopularTvShows(tvShowsResponseList: ArrayList<TvShowsResponse>) {
        popularTvShowsAdapter.addToAdapter(tvShowsResponseList)
    }

    private fun clickedPopularMovieItem(data: MovieResponse) {
        TmdbApp.clickedMovieId = data.id
        Log.e("clickedDataBind", "done")
        val bundle = Bundle().apply {
            putParcelable(Keys.MOVIE_RESPONSE, data)
        }
        navigateSafe(resId = R.id.action_homeFragment_to_contentDetailFragment, bundle)
    }


    private fun clickedPopularTvShowsItem(data: TvShowsResponse) {

        val bundle = Bundle().apply {
            putParcelable(Keys.TV_SHOWS_RESPONSE, data)
        }
        navigateSafe(resId = R.id.action_homeFragment_to_tvShowsDetailFragment, bundle)
    }

    override fun getResourceLayoutId(): Int = R.layout.fragment_home
}