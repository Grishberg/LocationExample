package com.grishberg.gpsexample.di.modules

import com.grishberg.gpsexample.App
import com.grishberg.gpsexample.common.Logger
import com.grishberg.gpsexample.common.LogCatLogger
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by grishberg on 08.10.17.
 */
@Module
class AppModule(val app: App) {
    @Provides
    @Singleton
    fun provideApp() = app

    @Provides
    @Singleton
    fun provideLogger() : Logger = LogCatLogger()

    @Provides
    @Singleton
    fun provideAppContext() = app.applicationContext
}