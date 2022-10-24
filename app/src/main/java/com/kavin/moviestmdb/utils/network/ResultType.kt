package com.kavin.moviestmdb.utils.network

/**
 * Created by Kavin on 22/01/2022.
 */
sealed class ResultType<out T : Any> {
    data class Success<out T : Any>(val data: T) : ResultType<T>()
    data class Error(val error: Exception) : ResultType<Nothing>()
}