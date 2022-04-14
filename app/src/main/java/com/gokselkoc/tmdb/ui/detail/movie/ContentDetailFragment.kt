package com.gokselkoc.tmdb.ui.detail.movie

import com.gokselkoc.tmdb.R
import com.gokselkoc.tmdb.base.BaseVmDbFragment
import com.gokselkoc.tmdb.constants.Keys
import com.gokselkoc.tmdb.databinding.FragmentContentDetailBinding
import com.gokselkoc.tmdb.models.movie.MovieResponse
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class ContentDetailFragment : BaseVmDbFragment<FragmentContentDetailBinding>() {


    override fun onInitDataBinding() {
        val movieResponse = arguments?.get(Keys.MOVIE_RESPONSE) as MovieResponse
        viewBinding.movieResponse = movieResponse
    }

    override fun getResourceLayoutId(): Int = R.layout.fragment_content_detail
}