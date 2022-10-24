package com.kavin.moviestmdb.movies.data

import com.kavin.moviestmdb.detail.data.TrailerResponse
import com.kavin.moviestmdb.utils.network.ResultType

interface MovieRepo {
    suspend fun getPopularMovies(page: Int): ResultType<MovieResponse>
    suspend fun getFilteredPopularMovies(filterText: String): MovieResponse?
    suspend fun fetchMovieTrailers(movieId: Int): ResultType<TrailerResponse>?
    fun isMovieLiked(id: Int): Boolean
    fun changeLikeState(movie: Movie, newLikeState: Boolean)
}