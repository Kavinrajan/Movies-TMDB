package com.kavin.moviestmdb.utils.di.component

import com.kavin.moviestmdb.MovieApp
import com.kavin.moviestmdb.utils.database.DbModule
import com.kavin.moviestmdb.utils.di.module.AppModule
import com.kavin.moviestmdb.utils.di.module.RepoModule
import com.kavin.moviestmdb.utils.network.UrlModule
import com.kavin.moviestmdb.utils.network.NetworkModule
import com.kavin.moviestmdb.utils.di.builder.ActivityBuilder
import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Singleton

/**
 * Created by Kavin on 19/8/2021.
 */

@Singleton
@Component(modules = [(AndroidInjectionModule::class), (AppModule::class), (DbModule::class),
    (NetworkModule::class), (UrlModule::class),(RepoModule::class), (ActivityBuilder::class)])

interface AppComponent : AndroidInjector<DaggerApplication> {

    fun inject(app: MovieApp)

    override fun inject(instance: DaggerApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}