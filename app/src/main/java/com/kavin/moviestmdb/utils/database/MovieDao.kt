package com.kavin.moviestmdb.utils.database

import com.kavin.moviestmdb.movies.data.Movie
import androidx.room.*

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: Movie)

    @Query("SELECT id FROM movies")
    fun fetchFavouriteMovies(): List<Int?>

    @Delete()
    fun removeMovie(movie: Movie)

}