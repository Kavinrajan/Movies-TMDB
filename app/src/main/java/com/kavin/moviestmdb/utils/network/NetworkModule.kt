/*
 * *
 *  Created by Kavin on  19/8/2021.
 * /
 */

package com.kavin.moviestmdb.utils.network

import com.kavin.moviestmdb.movies.data.MovieApi
import com.kavin.moviestmdb.detail.data.TrailerApi
import com.kavin.moviestmdb.utils.commons.AppConstants.Companion.BASE_URL_KEY
import android.content.Context
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by Kavin on 15/11/2021.
 */

@Module
class NetworkModule {

    @Provides
    @Singleton
    internal fun provideNetworkInterceptor(mContext: Context): NetworkInterceptor {
        return NetworkInterceptor(mContext)
    }

    @Provides
    @Singleton
    internal fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    @Provides
    @Singleton
    internal fun provideOkHttpClient(NetworkInterceptor: NetworkInterceptor
                                     , httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient.Builder {
        return OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(NetworkInterceptor)
    }

    @Provides
    @Singleton
    internal fun provideRetrofit(@Named(BASE_URL_KEY) baseUrl: String,okHttpClient: OkHttpClient.Builder): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient.build())
                .baseUrl(baseUrl)
                .build()
    }


    @Provides
    @Singleton
    internal fun provideMovieApi(retrofit: Retrofit): MovieApi {
        return retrofit.create(MovieApi::class.java)
    }

    @Provides
    @Singleton
    internal fun provideTrailerApi(retrofit: Retrofit): TrailerApi {
        return retrofit.create(TrailerApi::class.java)
    }

}