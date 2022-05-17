package com.gokselkoc.tmdb.ui.detail.movie

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.gokselkoc.tmdb.R
import com.gokselkoc.tmdb.base.BaseVmDbFragment
import com.gokselkoc.tmdb.constants.Keys
import com.gokselkoc.tmdb.databinding.FragmentMovieDetailBinding
import com.gokselkoc.tmdb.extension.observe
import com.gokselkoc.tmdb.domain.models.movie.MovieResponse
import com.gokselkoc.tmdb.domain.models.moviedetail.MovieDetailResponse
import com.gokselkoc.tmdb.domain.models.moviedetail.image.ImageUIModel
import com.gokselkoc.tmdb.domain.models.moviedetail.trailer.TrailerUIModel
import com.gokselkoc.tmdb.extension.navigateToDirection
import com.gokselkoc.tmdb.ui.detail.movie.genre.GenreAdapter
import com.gokselkoc.tmdb.ui.detail.movie.image.ImageAdapter
import com.gokselkoc.tmdb.ui.detail.movie.trailer.TrailerAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MovieDetailFragment : BaseVmDbFragment<FragmentMovieDetailBinding>() {

    private val viewModel by viewModels<MovieDetailViewModel>()

    private val genreAdapter: GenreAdapter by lazy {
        GenreAdapter(
            ArrayList()
        )
    }

    private val trailerAdapter: TrailerAdapter by lazy {
        TrailerAdapter(
            ArrayList(),
            viewModel
        )
    }

    private val imageAdapter: ImageAdapter by lazy {
        ImageAdapter(
            ArrayList(),
            onImageClicked = ::clickedImage
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observe(viewModel.clickedTrailer, ::clickedTrailer)
        observe(viewModel.movieTrailerResponse, ::getMovieTrailer)

    }


    override fun onInitDataBinding() {

        val movieResponse = arguments?.get(Keys.MOVIE_RESPONSE) as MovieResponse

        observe(viewModel.movieDetailResponse, ::getMovieDetail)

        observe(viewModel.movieTrailerResponse, ::getMovieTrailer)

        observe(viewModel.movieImageResponse, ::getMovieImage)


        binding.movieResponse = movieResponse

    }

    private fun getMovieDetail(data: MovieDetailResponse) {
        if (genreAdapter.list.isNotEmpty()) {
            genreAdapter.list.clear()
        }
        genreAdapter.addToAdapter(data.genres)
        binding.genreRecyclerView.adapter = genreAdapter
    }

    private fun getMovieTrailer(data: ArrayList<TrailerUIModel>) {
        if (trailerAdapter.list.isNotEmpty()) {
            trailerAdapter.list.clear()
        }
        trailerAdapter.addToAdapter(data)
        binding.trailerRecyclerView.adapter = trailerAdapter
    }

    private fun getMovieImage(data: ArrayList<ImageUIModel>) {
        if (imageAdapter.list.isNotEmpty()) {
            imageAdapter.list.clear()
        }
        imageAdapter.addToAdapter(data)
        binding.imageRecyclerView.adapter = imageAdapter
    }

    private fun clickedTrailer(data: TrailerUIModel) {
        navigateToDirection(MovieDetailFragmentDirections.actionMovieDetailFragmentToTrailerActivity(
            data.key), binding)
    }

    private fun clickedImage(data: ImageUIModel, position: Int) {
        navigateToDirection(
            MovieDetailFragmentDirections.actionMovieDetailFragmentToImageNavGraph(
                images = viewModel.movieImageResponse.value!!.toTypedArray(),
                position = position),
            binding)
    }

    override fun getResourceLayoutId(): Int = R.layout.fragment_movie_detail
}