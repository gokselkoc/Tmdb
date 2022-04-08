package com.gokselkoc.tmdb.di

import com.gokselkoc.tmdb.BuildConfig
import com.gokselkoc.tmdb.api.MovieApiService
import com.gokselkoc.tmdb.api.interceptor.ApplicationInterceptor
import com.gokselkoc.tmdb.constants.ApiConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Provides
    fun provideBaseUrl() = ApiConstants.API_URL

    @Singleton
    @Provides
    fun provideOkHttpClient(applicationInterceptor: ApplicationInterceptor) =
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(applicationInterceptor)
                .build()
        } else {
            OkHttpClient
                .Builder()
                .addInterceptor(applicationInterceptor)
                .build()
        }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL: String): Retrofit = Retrofit.Builder()
        .addConverterFactory(JacksonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideMovieApiService(retrofit: Retrofit): MovieApiService {
        return retrofit.create(MovieApiService::class.java)
    }


}