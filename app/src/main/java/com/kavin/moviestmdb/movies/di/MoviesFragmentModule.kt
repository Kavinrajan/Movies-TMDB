

package com.kavin.moviestmdb.movies.di

import com.kavin.moviestmdb.utils.commons.GridSpacingItemDecoration
import com.kavin.moviestmdb.movies.view.MovieAdapter
import com.kavin.moviestmdb.movies.view.MoviesFragment
import androidx.recyclerview.widget.GridLayoutManager
import dagger.Module
import dagger.Provides

/**
 * Created by Kavin on 19/8/2021.
 */

@Module
class MoviesFragmentModule {

    @Provides
    internal fun provideGridLayoutManager(fragment: MoviesFragment): GridLayoutManager {
        return GridLayoutManager(fragment.requireContext(), 2)
    }

    @Provides
    internal fun provideGridSpacingItemDecoration(): GridSpacingItemDecoration {
        return GridSpacingItemDecoration(2, 5, true)
    }

    @Provides
    internal fun provideMovieAdapter(): MovieAdapter {
        return MovieAdapter()
    }

}