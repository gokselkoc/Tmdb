package com.gokselkoc.tmdb.di

import com.gokselkoc.tmdb.api.MovieApiService
import com.gokselkoc.tmdb.api.TvShowsApiService
import com.gokselkoc.tmdb.repositories.movie.MovieRepository
import com.gokselkoc.tmdb.repositories.movie.MovieRepositoryImpl
import com.gokselkoc.tmdb.repositories.tvshows.TvShowsRepository
import com.gokselkoc.tmdb.repositories.tvshows.TvShowsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {


    @Singleton
    @Provides
    fun provideMovieRepository(movieApiService: MovieApiService): MovieRepository {
        return MovieRepositoryImpl(movieApiService)
    }

    @Singleton
    @Provides
    fun provideTvShowsRepository(tvShowsApiService: TvShowsApiService) : TvShowsRepository{
        return TvShowsRepositoryImpl(tvShowsApiService = tvShowsApiService)
    }


}