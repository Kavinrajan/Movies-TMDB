package com.kavin.moviestmdb.movies.domain

import com.kavin.moviestmdb.movies.data.Movie
import com.kavin.moviestmdb.movies.data.MovieFilterSource
import com.kavin.moviestmdb.movies.data.MoviePagingSource
import androidx.paging.PagingSource
import javax.inject.Inject

class MovieSourceFactory @Inject constructor() {

    @Inject
    lateinit var movieFilterSource: MovieFilterSource

    @Inject
    lateinit var moviePagingSource: MoviePagingSource

    fun getSource( filterText: String): PagingSource<Int, Movie> {
        return if (filterText.isBlank() || filterText.isEmpty()) moviePagingSource
        else movieFilterSource.apply { this.filterText = filterText }
    }
}
