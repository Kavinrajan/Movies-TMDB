package com.kavin.moviestmdb.detail.data

import com.kavin.moviestmdb.utils.commons.AppConstants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Kavin on 15/11/2021.
 */

interface TrailerApi {


    companion object {

        const val GET_MOVIE_TRAILERS: String = ("movie/{movie_id}/videos")
    }

    @GET(GET_MOVIE_TRAILERS)
    suspend fun getMovieTrailer(@Path("movie_id") id: Int, @Query(AppConstants.API_KEY_QUERY) apiKey: String): Response<TrailerResponse>
}