package com.kavin.moviestmdb.utils.network

import com.kavin.moviestmdb.BuildConfig
import com.kavin.moviestmdb.utils.commons.AppConstants.Companion.BASE_URL_KEY
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class UrlModule {
    @Provides
    @Singleton
    @Named(BASE_URL_KEY)
    fun provideBaseUrl(): String {
        return BuildConfig.BASE_URL
    }
}