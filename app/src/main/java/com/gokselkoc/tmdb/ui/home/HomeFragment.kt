package com.gokselkoc.tmdb.ui.home


import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.gokselkoc.tmdb.R
import com.gokselkoc.tmdb.base.BaseVmDbFragment
import com.gokselkoc.tmdb.constants.Keys
import com.gokselkoc.tmdb.databinding.FragmentHomeBinding
import com.gokselkoc.tmdb.extension.navigateSafe
import com.gokselkoc.tmdb.extension.observe
import com.gokselkoc.tmdb.models.movie.MovieResponse
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class HomeFragment : BaseVmDbFragment<FragmentHomeBinding>() {


    private val viewModel by viewModels<MovieViewModel>()

    private val contentAdapter: ContentAdapter by lazy {
        ContentAdapter(
            ArrayList(),
            viewModel,
        )
    }

    override fun onInitDataBinding() {
        observe(viewModel.popularMovieResponse, ::homeGetPopularMovies)
        homeClickedItem()
        recyclerViewScroll()
        viewBinding.popularMovieRecyclerView.adapter = contentAdapter
    }

    fun recyclerViewScroll() {
        with(viewBinding.popularMovieRecyclerView) {

            addOnScrollListener(object : RecyclerView.OnScrollListener() {

                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)

                    if (!viewBinding.popularMovieRecyclerView.canScrollHorizontally(1)) {

                        viewModel.addNewItemsPopularMovies()
                    }
                }
            })
        }
    }

    private fun homeGetPopularMovies(movieResponseList: ArrayList<MovieResponse>) {
        contentAdapter.addToAdapter(movieResponseList)
    }

    override fun getResourceLayoutId(): Int = R.layout.fragment_home

    private fun homeClickedItem() {
        lifecycleScope.launch {
            viewModel.onClickedItemFlow.collect { clickedItem ->
                navigateClickedItemDetailFragment(clickedItem)
            }
        }
    }

    private fun navigateClickedItemDetailFragment(clickedItem: MovieResponse) {
        val bundle = Bundle().apply {
            putParcelable(Keys.MOVIE_RESPONSE, clickedItem)
        }
        navigateSafe(resId = R.id.action_homeFragment_to_contentDetailFragment, bundle)
    }
}