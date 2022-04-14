package com.gokselkoc.tmdb.ui.movies

import com.gokselkoc.tmdb.R
import com.gokselkoc.tmdb.base.BaseVmDbFragment
import com.gokselkoc.tmdb.databinding.FragmentMoviesBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MoviesFragment : BaseVmDbFragment<FragmentMoviesBinding>() {

    override fun onInitDataBinding() {

    }

    override fun getResourceLayoutId(): Int = R.layout.fragment_movies
}