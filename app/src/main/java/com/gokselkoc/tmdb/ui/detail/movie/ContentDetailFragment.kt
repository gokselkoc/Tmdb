package com.gokselkoc.tmdb.ui.detail.movie

import com.gokselkoc.tmdb.R
import com.gokselkoc.tmdb.base.BaseVmDbFragment
import com.gokselkoc.tmdb.databinding.FragmentContentDetailBinding
import com.gokselkoc.tmdb.ui.home.HomeFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class ContentDetailFragment : BaseVmDbFragment<FragmentContentDetailBinding>() {


    override fun onInitDataBinding() {

    }

    override fun getResourceLayoutId(): Int = R.layout.fragment_content_detail
}