

package com.kavin.moviestmdb.utils.di.builder

import com.kavin.moviestmdb.detail.di.MoreDetailFragmentProvider
import com.kavin.moviestmdb.main.di.MainActivityModule
import com.kavin.moviestmdb.movies.di.MoviesFragmentProvider
import com.kavin.moviestmdb.main.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Kavin on 19/8/2021.
 */

@Module
abstract class ActivityBuilder {


    @ContributesAndroidInjector(modules = [(MainActivityModule::class), (MoviesFragmentProvider::class), (MoreDetailFragmentProvider::class)])
    internal abstract fun bindMainActivity(): MainActivity

}