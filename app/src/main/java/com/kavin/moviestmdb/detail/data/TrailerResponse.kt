package com.kavin.moviestmdb.detail.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Kavin on 19/8/2021.
 */
@Parcelize
data class TrailerResponse(
        var id: Int,
        var results: List<TrailerRemote>
) : Parcelable
