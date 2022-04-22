package com.gokselkoc.tmdb.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TmdbApp : Application() {

    companion object {
        var clickedMovieId: Int = 0
    }
}