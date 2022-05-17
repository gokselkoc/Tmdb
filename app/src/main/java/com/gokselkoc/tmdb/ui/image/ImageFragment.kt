package com.gokselkoc.tmdb.ui.image

import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.gokselkoc.tmdb.R
import com.gokselkoc.tmdb.base.BaseVmDbFragment
import com.gokselkoc.tmdb.databinding.FragmentImageBinding
import com.gokselkoc.tmdb.domain.models.moviedetail.image.ImageUIModel
import com.gokselkoc.tmdb.ui.detail.movie.image.ImageAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlin.math.abs

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class ImageFragment : BaseVmDbFragment<FragmentImageBinding>() {

    private val imageFragmentArgs: ImageFragmentArgs by navArgs()

    private val imageAdapter: ImageAdapter by lazy {
        ImageAdapter(
            ArrayList(),
            isFullScreen = true
        )
    }

    override fun onInitDataBinding() {

        val compositePageTransformer = CompositePageTransformer()

        compositePageTransformer.addTransformer(MarginPageTransformer(40))

        compositePageTransformer.addTransformer { page, position ->
            val r = 1f.minus(abs(position))
            page.scaleY = 0.85f + r * 0.15f
        }

        imageAdapter.addToAdapter(imageFragmentArgs.images.toMutableList() as ArrayList<ImageUIModel>)

        binding.imageViewPager.apply {
            adapter = imageAdapter
            currentItem = imageFragmentArgs.position
            clipToPadding = false
            clipChildren = false
            setPageTransformer(compositePageTransformer)
        }
    }


    override fun getResourceLayoutId(): Int = R.layout.fragment_image
}