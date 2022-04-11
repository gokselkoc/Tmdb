package com.gokselkoc.tmdb.ui.home


import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gokselkoc.tmdb.R
import com.gokselkoc.tmdb.base.BaseVmDbFragment
import com.gokselkoc.tmdb.constants.Keys
import com.gokselkoc.tmdb.databinding.FragmentHomeBinding
import com.gokselkoc.tmdb.extension.navigateSafe
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
        homeGetPopularMovies()
        homeClickedItem()
        //Scroll Listener
        // recyclerViewScroll()
    }

    fun recyclerViewScroll() {
        with(viewBinding.popularMovieRecyclerView) {

            addOnScrollListener(object : RecyclerView.OnScrollListener() {

                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    val layoutManager: LinearLayoutManager = layoutManager as LinearLayoutManager

                    val visibleItemCount = layoutManager.childCount
                    val totalItemCount = layoutManager.itemCount
                    // val lastAdapterItemPositon = layoutManager.findLastVisibleItemPosition()
                    val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()


                    if (visibleItemCount + firstVisibleItemPosition >= totalItemCount - 3 && firstVisibleItemPosition >= 0) {

                        viewModel.addNewItemsPopularMovies()
                        homeGetPopularMovies()
                    }
                }
            })
        }
    }

    override fun getResourceLayoutId(): Int = R.layout.fragment_home


    private fun updatePopularMovies() {
        lifecycleScope.launch {
            viewModel.popularMovieRespons.collect { movieGeneralResponse ->
                movieGeneralResponse.results.let { movieResponse ->
                    contentAdapter.addToAdapter(movieResponse)
                }
            }
        }
        viewBinding.popularMovieRecyclerView.adapter = contentAdapter
    }

    private fun homeGetPopularMovies() {
        lifecycleScope.launch {
            viewModel.popularMovieRespons.collect { movieGeneralResponse ->
                movieGeneralResponse.results.let { movieResponse ->
                    contentAdapter.addToAdapter(movieResponse)
                }
            }
        }
        viewBinding.popularMovieRecyclerView.adapter = contentAdapter
    }

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