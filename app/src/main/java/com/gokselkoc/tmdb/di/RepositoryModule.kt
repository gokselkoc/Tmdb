package com.gokselkoc.tmdb.di

import com.gokselkoc.tmdb.api.MovieApiService
import com.gokselkoc.tmdb.repositories.movie.MovieRepository
import com.gokselkoc.tmdb.repositories.movie.MovieRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@InstallIn(ViewModelComponent::class)
@Module
class RepositoryModule {


    lateinit var  movieApiService: MovieApiService

    @Singleton
    @Provides
    fun provideMovieRepository():MovieRepository{
        return MovieRepositoryImpl(movieApiService)
    }
}