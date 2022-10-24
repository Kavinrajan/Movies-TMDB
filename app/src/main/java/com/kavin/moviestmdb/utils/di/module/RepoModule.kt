/*
 * *
 *  Created by Kavin on  19/8/2021.
 * /
 */

package com.kavin.moviestmdb.utils.di.module

import com.kavin.moviestmdb.detail.data.TrailerApi
import com.kavin.moviestmdb.movies.data.MovieApi
import com.kavin.moviestmdb.movies.data.MovieRepo
import com.kavin.moviestmdb.movies.data.MovieRepoImp
import com.kavin.moviestmdb.utils.database.MovieDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Kavin on 15/11/2021.
 */

@Module
class RepoModule {

    @Provides
    @Singleton
    internal fun provideMovieRepository(movieDao: MovieDao,
                                        movieApi: MovieApi,
                                        trailerApi: TrailerApi): MovieRepo {
        return MovieRepoImp(movieDao, movieApi, trailerApi)
    }

}