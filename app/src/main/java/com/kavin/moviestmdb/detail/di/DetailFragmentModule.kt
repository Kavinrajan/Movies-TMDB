package com.kavin.moviestmdb.detail.di

import com.kavin.moviestmdb.detail.view.MoreDetailFragment
import com.kavin.moviestmdb.detail.view.TrailerAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.Module
import dagger.Provides

/**
 * Created by Kavin on 19/8/2021.
 */

@Module
class MoreDetailFragmentModule {

    @Provides
    internal fun provideLinearLayoutManager(fragment: MoreDetailFragment): LinearLayoutManager {
        return LinearLayoutManager(fragment.activity)
    }

    @Provides
    internal fun provideTrailerAdapter(): TrailerAdapter {
        return TrailerAdapter(ArrayList())
    }

}