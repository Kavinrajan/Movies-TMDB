

package com.kavin.moviestmdb.detail.di

import com.kavin.moviestmdb.detail.view.MoreDetailFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Kavin on 19/8/2021.
 */

@Module
abstract class MoreDetailFragmentProvider {

    @ContributesAndroidInjector(modules =[(MoreDetailFragmentModule::class)])
    internal abstract fun provideMoreDetailFragmentFactory(): MoreDetailFragment

}