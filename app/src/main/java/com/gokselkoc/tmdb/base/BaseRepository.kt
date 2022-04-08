package com.gokselkoc.tmdb.base

import com.gokselkoc.tmdb.BuildConfig
import com.gokselkoc.tmdb.resource.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

@ExperimentalCoroutinesApi
abstract class BaseRepository {

    fun <T : Any> onApiCall(call: suspend () -> T): Flow<Resource<T>> =
        flow {
            emit(Resource.loading(null))
            emit(Resource.success(data = call.invoke()))
        }.catch { error ->
            if (BuildConfig.DEBUG) {
                error.printStackTrace()
            }
            emit(Resource.error(error.localizedMessage, null))
        }.flowOn(Dispatchers.IO)
}
