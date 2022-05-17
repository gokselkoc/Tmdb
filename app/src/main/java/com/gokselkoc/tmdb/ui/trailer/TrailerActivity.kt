package com.gokselkoc.tmdb.ui.trailer

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.navArgs
import com.gokselkoc.tmdb.R
import com.gokselkoc.tmdb.constants.ApiConstants
import com.gokselkoc.tmdb.databinding.ActivityTrailerBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer


class TrailerActivity : YouTubeBaseActivity() {

    lateinit var binding: ActivityTrailerBinding
    lateinit var youTubePlayer: YouTubePlayer

    val trailerActivityArgs : TrailerActivityArgs by navArgs()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_trailer)




        binding.youtubePlayerView.initialize(ApiConstants.YOUTUBE_API_KEY,
            object : YouTubePlayer.OnInitializedListener {
                override fun onInitializationSuccess(
                    p0: YouTubePlayer.Provider?,
                    p1: YouTubePlayer?,
                    p2: Boolean,
                ) {
                    p1?.let {
                        youTubePlayer = p1
                    }
                    youTubePlayer.loadVideo(trailerActivityArgs.urlKey)
                    youTubePlayer.play()
                }

                override fun onInitializationFailure(
                    p0: YouTubePlayer.Provider?,
                    p1: YouTubeInitializationResult?,
                ) {
                    Snackbar.make(binding.root, "Video Player Failed", Snackbar.LENGTH_LONG).show()
                }
            })
    }
}