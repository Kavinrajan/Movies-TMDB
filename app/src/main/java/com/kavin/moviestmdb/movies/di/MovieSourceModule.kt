package com.kavin.moviestmdb.movies.di

import com.kavin.moviestmdb.movies.data.MovieFilterSource
import com.kavin.moviestmdb.movies.data.MoviePagingSource
import com.kavin.moviestmdb.movies.data.MovieRepoImp
import com.kavin.moviestmdb.movies.domain.MovieSourceFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MovieSourceModule {
    @Provides
    internal fun provideMoviesSource(): MovieSourceFactory {
        return MovieSourceFactory()
    }

    @Provides
    @Singleton
    internal fun provideMoviesPagingSource(movieRepoImp: MovieRepoImp): MoviePagingSource {
        return MoviePagingSource(movieRepoImp)
    }

    @Provides
    @Singleton
    internal fun provideMoviesFilterSource(movieRepoImp: MovieRepoImp): MovieFilterSource {
        return MovieFilterSource(movieRepoImp)
    }
}