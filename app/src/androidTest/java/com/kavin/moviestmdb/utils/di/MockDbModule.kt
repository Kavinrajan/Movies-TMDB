package com.kavin.moviestmdb.utils.di

import com.kavin.moviestmdb.utils.commons.AppConstants
import com.kavin.moviestmdb.utils.database.MovieDao
import com.kavin.moviestmdb.utils.database.MovieDb
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class MockDbModule {
        @Provides
        @Singleton
        @Named(AppConstants.DB_NAME_KEY)
        internal fun provideMovieDb(context: Context): MovieDb {
            return Room.databaseBuilder(context, MovieDb::class.java, AppConstants.DB_MOCK_NAME).fallbackToDestructiveMigration()
                    .build()
        }

        @Provides
        @Singleton
        internal fun provideMovieDao(context: Context): MovieDao {
            return provideMovieDb(context).movieDao()
        }
}