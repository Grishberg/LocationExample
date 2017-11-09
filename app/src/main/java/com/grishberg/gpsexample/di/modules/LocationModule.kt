package com.grishberg.gpsexample.di.modules

import android.content.Context
import com.grishberg.gpsexample.data.gps.LocationProvider
import com.grishberg.gpsexample.data.gps.LocationProviderImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by grishberg on 09.11.17.
 */
@Module
class LocationModule {
    @Singleton
    @Provides
    fun provideLocationProvider(context: Context): LocationProvider = LocationProviderImpl(context)
}