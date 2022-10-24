package com.kavin.moviestmdb.movies.data


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Kavin on 19/8/2021.
 */
@Parcelize
data class MovieResponse(
        var page: Int?,
        var total_results: Int?,
        var total_pages: Int,
        var results: ArrayList<Movie>) : Parcelable

