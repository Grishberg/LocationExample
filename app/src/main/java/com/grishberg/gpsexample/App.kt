package com.grishberg.gpsexample

import android.app.Application
import com.grishberg.gpsexample.di.DaggerAppComponent

import com.grishberg.gpsexample.di.DiManager
import com.grishberg.gpsexample.di.modules.AppModule
import com.grishberg.gpsexample.di.modules.LocationModule
import com.grishberg.gpsexample.di.modules.RestModule

/**
 * Created by grishberg on 11.10.17.
 */

class App : Application() {
    override fun onCreate() {
        DiManager.initComponents(DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .restModule(RestModule(""/*getString(R.string.end_point))*/))
                .locationModule(LocationModule())
                .build()
        )
    }
}
