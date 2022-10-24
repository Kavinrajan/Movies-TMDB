package com.kavin.moviestmdb.utils.di

import com.kavin.moviestmdb.MovieApp
import com.kavin.moviestmdb.utils.di.builder.ActivityBuilder
import com.kavin.moviestmdb.utils.di.component.AppComponent
import com.kavin.moviestmdb.utils.di.module.AppModule
import com.kavin.moviestmdb.utils.network.NetworkModule
import com.kavin.moviestmdb.utils.di.module.RepoModule
import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.DaggerApplication
import okhttp3.mockwebserver.MockWebServer
import javax.inject.Singleton


@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    MockDbModule::class,
    NetworkModule::class,
    RepoModule::class,
    ActivityBuilder::class,
    MockUrlModule::class
]
)
interface TestAppComponent : AppComponent {

    override fun inject(app: MovieApp)

    override fun inject(instance: DaggerApplication)

    fun getMockWebServer(): MockWebServer

    @Component.Builder
    interface Builder {

        /**
         * [BindsInstance] annotation is used for, if you want to bind particular object or instance
         * of an object through the time of component construction
         */
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): TestAppComponent
    }

}