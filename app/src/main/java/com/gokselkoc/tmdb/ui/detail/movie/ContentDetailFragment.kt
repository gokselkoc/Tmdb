package com.gokselkoc.tmdb.ui.detail.movie

import android.util.Log
import androidx.fragment.app.viewModels
import com.gokselkoc.tmdb.R
import com.gokselkoc.tmdb.base.BaseVmDbFragment
import com.gokselkoc.tmdb.constants.Keys
import com.gokselkoc.tmdb.databinding.FragmentContentDetailBinding
import com.gokselkoc.tmdb.extension.observe
import com.gokselkoc.tmdb.models.movie.MovieResponse
import com.gokselkoc.tmdb.models.moviedetail.MovieDetailResponse
import com.gokselkoc.tmdb.ui.detail.movie.genre.GenreAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class ContentDetailFragment : BaseVmDbFragment<FragmentContentDetailBinding>() {

    private val viewModel by viewModels<MovieDetailViewModel>()

    private val genreAdapter: GenreAdapter by lazy {
        GenreAdapter(
            ArrayList()
        )
    }


    override fun onInitDataBinding() {
        val movieResponse = arguments?.get(Keys.MOVIE_RESPONSE) as MovieResponse

        if (genreAdapter.list.isEmpty()) {
            observe(viewModel.movieDetailResponse, ::getMovieDetailFragment)

        }

        binding.movieResponse = movieResponse
    }

    private fun getMovieDetailFragment(data: MovieDetailResponse) {

        genreAdapter.addToAdapter(data.genres)
        binding.genreRecyclerView.adapter = genreAdapter
    }


    override fun getResourceLayoutId(): Int = R.layout.fragment_content_detail
}