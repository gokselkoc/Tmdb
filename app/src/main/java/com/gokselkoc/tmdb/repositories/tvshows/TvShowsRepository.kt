package com.gokselkoc.tmdb.repositories.tvshows

import com.gokselkoc.tmdb.domain.models.tvshows.TvShowsGeneralResponse
import com.gokselkoc.tmdb.resource.Resource
import kotlinx.coroutines.flow.Flow

interface TvShowsRepository {

    fun getPopularTvShows(page: Int): Flow<Resource<TvShowsGeneralResponse>>
}