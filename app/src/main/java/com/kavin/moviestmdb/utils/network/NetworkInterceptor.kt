package com.kavin.moviestmdb.utils.network

import android.content.Context
import android.net.ConnectivityManager
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by Kavin on 22/01/2022.
 */
@Singleton
class NetworkInterceptor @Inject constructor(private val mContext: Context) : Interceptor {

    private val isConnected: Boolean
        get() {
            val connectivityManager = mContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val netInfo = connectivityManager.activeNetworkInfo
            return netInfo != null && netInfo.isConnected
        }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isConnected) throw NoConnectionException()
        val builder = chain.request().newBuilder()
        return chain.proceed(builder.build())
    }

}