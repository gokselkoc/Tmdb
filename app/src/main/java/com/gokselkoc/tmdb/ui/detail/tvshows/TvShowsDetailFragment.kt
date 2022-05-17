package com.gokselkoc.tmdb.ui.detail.tvshows

import com.gokselkoc.tmdb.R
import com.gokselkoc.tmdb.base.BaseVmDbFragment
import com.gokselkoc.tmdb.constants.Keys
import com.gokselkoc.tmdb.databinding.FragmentTvShowsDetailBinding
import com.gokselkoc.tmdb.domain.models.tvshows.TvShowsResponse
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
@AndroidEntryPoint
class TvShowsDetailFragment : BaseVmDbFragment<FragmentTvShowsDetailBinding>() {


    override fun onInitDataBinding() {
        val tvShowResponse = arguments?.get(Keys.TV_SHOWS_RESPONSE) as TvShowsResponse
        binding.tvShowsResponse = tvShowResponse
    }

    override fun getResourceLayoutId(): Int = R.layout.fragment_tv_shows_detail
}