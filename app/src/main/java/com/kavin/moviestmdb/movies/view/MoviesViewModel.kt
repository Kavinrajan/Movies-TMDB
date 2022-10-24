package com.kavin.moviestmdb.movies.view

import com.kavin.moviestmdb.base.BaseViewModel
import com.kavin.moviestmdb.detail.view.MoreDetailViewState
import com.kavin.moviestmdb.movies.data.Movie
import com.kavin.moviestmdb.movies.data.MovieRepo
import com.kavin.moviestmdb.movies.domain.MovieSourceFactory
import com.kavin.moviestmdb.utils.commons.CoroutineDispatcher
import com.kavin.moviestmdb.utils.network.ResultType
import androidx.lifecycle.*
import androidx.paging.*
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import javax.inject.Inject


/**
 * Created by Kavin on 19/8/2021.
 */

class MoviesViewModel @Inject constructor(private val movieRepo: MovieRepo,
                                          private val sourceFactory: MovieSourceFactory,
                                          private val dispatcher: CoroutineDispatcher = CoroutineDispatcher()) : BaseViewModel() {

    companion object {
        private const val PAGE_SIZE = 20
        const val YOUTUBE_APP_URI = "vnd.youtube:"
        const val YOUTUBE_WEB_URI = "http://www.youtube.com/watch?v="
        const val POSTER_BASE_URL = "http://image.tmdb.org/t/p/w185"
    }

    private var movie: Movie? = null
    private val searchTextLiveData: MutableLiveData<String> = MutableLiveData("")
    var movies: LiveData<PagingData<Movie>> = MediatorLiveData()

    init {
      movies =  Transformations.switchMap(searchTextLiveData) { input: String ->
            return@switchMap getMoviesStream(input)
        }
    }

    private fun getMoviesStream(input: String): LiveData<PagingData<Movie>> {
        val result = viewModelScope.async { Pager(PagingConfig(PAGE_SIZE)) { sourceFactory.getSource(input) } }
        return runBlocking { result.await().liveData.cachedIn(viewModelScope)}
    }

    fun getLikeState(movieId: Int) {
        viewModelScope.launch(dispatcher.IO) {
            val likeState = movieRepo.isMovieLiked(movieId)
            withContext(dispatcher.Main) { updateViewState(MoreDetailViewState.LikeState(likeState)) }
        }
    }

    fun fetchMovieTrailers(movieId: Int) {
        viewModelScope.launch(dispatcher.IO) {
            val trailerList = movieRepo.fetchMovieTrailers(movieId)
            withContext(dispatcher.Main) {
                if (trailerList is ResultType.Success) updateViewState(MoreDetailViewState.TrailersFetchedSuccess(trailerList.data.results))
                else updateViewState(MoreDetailViewState.TrailersFetchedError)
            }
        }
    }

    fun updateLikeStatus(movie: Movie) {
        viewModelScope.launch(dispatcher.IO) {
            val newLikeState = movieRepo.isMovieLiked(movie.id).not()
            movieRepo.changeLikeState(movie, newLikeState)
            withContext(dispatcher.Main) {
                updateViewState(MoreDetailViewState.LikeState(newLikeState))
            }
        }
    }

    fun setSelectedMovie(movie: Movie) {
        this.movie = movie
    }

    fun getSelectedMovie(): Movie? {
        return movie
    }

    fun getSearchLiveData(): MutableLiveData<String> {
        return searchTextLiveData
    }

}