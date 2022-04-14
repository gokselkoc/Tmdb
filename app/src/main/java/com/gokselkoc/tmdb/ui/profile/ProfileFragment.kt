package com.gokselkoc.tmdb.ui.profile

import com.gokselkoc.tmdb.R
import com.gokselkoc.tmdb.base.BaseVmDbFragment
import com.gokselkoc.tmdb.databinding.FragmentProfileBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class ProfileFragment : BaseVmDbFragment<FragmentProfileBinding>() {

    override fun onInitDataBinding() {

    }

    override fun getResourceLayoutId(): Int = R.layout.fragment_profile
}