package com.gokselkoc.tmdb.ui.home


import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.gokselkoc.tmdb.R
import com.gokselkoc.tmdb.base.BaseVmDbFragment
import com.gokselkoc.tmdb.databinding.FragmentHomeBinding
import com.gokselkoc.tmdb.models.movie.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class HomeFragment : BaseVmDbFragment<FragmentHomeBinding>() {

    private val viewModel by viewModels<MovieViewModel>()

    override fun onInitDataBinding() {
        lifecycleScope.launch {
            viewModel.popularMovieRespone.collect {
                Log.e("it", it.toString())
            }
        }

    }

    override fun getResourceLayoutId(): Int = R.layout.fragment_home
}