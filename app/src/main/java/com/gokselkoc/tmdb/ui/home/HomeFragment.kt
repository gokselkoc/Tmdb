package com.gokselkoc.tmdb.ui.home


import com.gokselkoc.tmdb.R
import com.gokselkoc.tmdb.base.BaseVmDbFragment
import com.gokselkoc.tmdb.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class HomeFragment : BaseVmDbFragment<FragmentHomeBinding>() {


    override fun onInitDataBinding() {

    }

    override fun getResourceLayoutId(): Int = R.layout.fragment_home
}