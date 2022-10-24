package com.kavin.moviestmdb.movies.data

import com.kavin.moviestmdb.utils.commons.AppConstants.Companion.API_KEY_QUERY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

/**
 * Created by Kavin on 19/8/2021.
 */

@Singleton
interface MovieApi {


    companion object {
        const val POPULAR_MOVIES_QUERY: String = ("discover/movie?sort_by=popularity.desc")
        const val PAGE_QUERY: String = ("page")
    }



    @GET(POPULAR_MOVIES_QUERY)
    suspend fun getMostPopular(@Query(API_KEY_QUERY) apiKey: String,@Query(PAGE_QUERY) page:Int): Response<MovieResponse>




}