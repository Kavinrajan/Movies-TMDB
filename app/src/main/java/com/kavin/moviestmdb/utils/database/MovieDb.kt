package com.kavin.moviestmdb.utils.database

import com.kavin.moviestmdb.movies.data.Movie
import androidx.room.*
import javax.inject.Singleton

/**
 * Created by Kavin on 19/8/2021.
 */

@Singleton
@Database(entities = [(Movie::class)], version = 1, exportSchema = false)
abstract class MovieDb : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}


