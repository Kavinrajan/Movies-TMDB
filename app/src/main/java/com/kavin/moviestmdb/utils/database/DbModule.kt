/*
 * *
 *  Created by Kavin on 15/11/2021.
 * /
 */

package com.kavin.moviestmdb.utils.database

import com.kavin.moviestmdb.utils.commons.AppConstants
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by Kavin on 15/11/2021.
 */

@Module
class DbModule{

    @Provides
    @Singleton
    @Named(AppConstants.DB_NAME_KEY)
    internal fun provideMovieDb(context: Context): MovieDb {
        return Room.databaseBuilder(context, MovieDb::class.java, AppConstants.DB_NAME).fallbackToDestructiveMigration()
                .build()
    }

    @Provides
    @Singleton
    internal fun provideMovieDao(context: Context): MovieDao {
        return provideMovieDb(context).movieDao()
    }
}