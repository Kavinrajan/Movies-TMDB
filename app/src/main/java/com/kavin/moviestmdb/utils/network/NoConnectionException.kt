package com.kavin.moviestmdb.utils.network

import java.io.IOException

/**
 * Created by Kavin on 22/01/2022.
 */
class NoConnectionException : IOException() {

    // You can send any message whatever you want from here.
    override val message: String
        get() = "No Internet Connection"
}