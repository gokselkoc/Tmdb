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
            emit(Resource.error(error.localizedMessage,null))
        }.flowOn(Dispatchers.IO)
/*
    private fun recordException(error: Throwable) {
        Firebase.crashlytics.recordException(error)
    }

    fun <T : Any> onRoomCall(call: suspend () -> T): Flow<Resource<T>> =
        flow {
            emit(Resource.Loading)
            emit(Resource.Success(data = call.invoke()))
        }.catch { error ->
            if (BuildConfig.DEBUG) {
                error.printStackTrace()
            }
            recordException(error)
            emit(Resource.Error(error))
        }.flowOn(dispatcher)

    fun <T : Any?> onRoomFlowCall(call: Flow<T>): Flow<Resource<T>> =
        flow {
            emit(Resource.Loading)
            call.collect {
                emit(Resource.Success(it))
            }
        }.catch {
            recordException(Throwable("onRoomFlowCall"))
            emit(Resource.Error(it))
        }.flowOn(dispatcher)*/
}
