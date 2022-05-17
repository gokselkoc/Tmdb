package com.gokselkoc.tmdb.repositories.tvshows

import com.gokselkoc.tmdb.api.TvShowsApiService
import com.gokselkoc.tmdb.base.BaseRepository
import com.gokselkoc.tmdb.domain.models.tvshows.TvShowsGeneralResponse
import com.gokselkoc.tmdb.resource.Resource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ExperimentalCoroutinesApi
class TvShowsRepositoryImpl @Inject constructor(
    private val tvShowsApiService: TvShowsApiService,
) : TvShowsRepository, BaseRepository() {

    override fun getPopularTvShows(page: Int): Flow<Resource<TvShowsGeneralResponse>> {
        return onApiCall { tvShowsApiService.getPopularTvShows(page = page) }
    }
}