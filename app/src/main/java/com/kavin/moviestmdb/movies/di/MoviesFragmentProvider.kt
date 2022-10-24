

package com.kavin.moviestmdb.movies.di

import com.kavin.moviestmdb.movies.view.MoviesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Kavin on 19/8/2021.
 */

@Module
abstract class MoviesFragmentProvider {

    @ContributesAndroidInjector(modules =[(MoviesFragmentModule::class),(MovieSourceModule::class),])
    internal abstract fun provideMainFragmentFactory(): MoviesFragment

}