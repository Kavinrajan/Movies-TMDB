package com.kavin.moviestmdb.movies.view

import com.kavin.moviestmdb.movies.data.Movie
import androidx.paging.PagingData


sealed class MoviesViewState {
    class FetchingMoviesError(val errorMessage: String?) : MoviesViewState()
    class FetchingMoviesSuccess(val movies: PagingData<Movie>) : MoviesViewState()
}
