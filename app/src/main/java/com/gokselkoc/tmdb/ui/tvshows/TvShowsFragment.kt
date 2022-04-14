package com.gokselkoc.tmdb.ui.tvshows

import com.gokselkoc.tmdb.R
import com.gokselkoc.tmdb.base.BaseVmDbFragment
import com.gokselkoc.tmdb.databinding.FragmentTvShowsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class TvShowsFragment : BaseVmDbFragment<FragmentTvShowsBinding>() {

    override fun onInitDataBinding() {

    }

    override fun getResourceLayoutId(): Int = R.layout.fragment_tv_shows
}