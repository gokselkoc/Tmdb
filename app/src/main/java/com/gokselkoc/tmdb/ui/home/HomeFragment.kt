package com.gokselkoc.tmdb.ui.home


import android.os.Bundle
import androidx.fragment.app.viewModels
import com.gokselkoc.tmdb.R
import com.gokselkoc.tmdb.base.BaseVmDbFragment
import com.gokselkoc.tmdb.constants.Keys
import com.gokselkoc.tmdb.databinding.FragmentHomeBinding
import com.gokselkoc.tmdb.extension.navigateSafe
import com.gokselkoc.tmdb.extension.observe
import com.gokselkoc.tmdb.extension.scrollEndListener
import com.gokselkoc.tmdb.models.movie.MovieResponse
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class HomeFragment : BaseVmDbFragment<FragmentHomeBinding>() {


    private val viewModel by viewModels<HomeViewModel>()

    private val contentAdapter: ContentAdapter by lazy {
        ContentAdapter(
            ArrayList(),
            viewModel,
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observe(viewModel.onClickedItemLiveData, ::homeClickedItem)
    }


    override fun onInitDataBinding() {
        if (contentAdapter.list.isEmpty()) {
            observe(viewModel.popularMovieResponse, ::homeGetPopularMovies)
        }
        viewBinding.popularMovieRecyclerView.adapter = contentAdapter
        viewBinding.popularMovieRecyclerView.scrollEndListener {
            viewModel.addNewItemsPopularMovies()
        }
    }

    private fun homeGetPopularMovies(movieResponseList: ArrayList<MovieResponse>) {
        contentAdapter.addToAdapter(movieResponseList)
    }

    private fun homeClickedItem(data: MovieResponse) {
        navigateClickedItemDetailFragment(data)
    }

    private fun navigateClickedItemDetailFragment(clickedItem: MovieResponse) {
        val bundle = Bundle().apply {
            putParcelable(Keys.MOVIE_RESPONSE, clickedItem)
        }
        navigateSafe(resId = R.id.action_homeFragment_to_contentDetailFragment, bundle)
    }

    override fun getResourceLayoutId(): Int = R.layout.fragment_home
}