package com.kavin.moviestmdb.main.di

import com.kavin.moviestmdb.utils.commons.ViewModelProviderFactory
import com.kavin.moviestmdb.movies.view.MoviesViewModel
import com.kavin.moviestmdb.movies.data.MovieRepoImp
import com.kavin.moviestmdb.movies.domain.MovieSourceFactory
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides

/**
 * Created by Kavin on 19/8/2021.
 */

@Module
class MainActivityModule {

    @Provides
    internal fun provideMoviesViewModel(movieRepoImp: MovieRepoImp,sourceFactory:MovieSourceFactory): MoviesViewModel {
        return MoviesViewModel(movieRepoImp,sourceFactory)
    }

    @Provides
    internal fun provideMoviesViewModelFactory(moviesViewModel: MoviesViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(moviesViewModel)
    }

}