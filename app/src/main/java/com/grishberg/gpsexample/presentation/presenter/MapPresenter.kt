package com.grishberg.gpsexample.presentation.presenter

import android.location.LocationManager
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.google.android.gms.maps.GoogleMap
import com.grishberg.gpsexample.common.Logger
import com.grishberg.gpsexample.data.gps.LocationProvider
import com.grishberg.gpsexample.di.DiManager
import com.grishberg.gpsexample.presentation.ui.MapScreenView
import com.grishberg.gpsexample.presentation.ui.common.OnPermissionListener
import javax.inject.Inject

/**
 * Created by grishberg on 08.11.17.
 */
@InjectViewState
class MapPresenter : MvpPresenter<MapScreenView>() {
    @Inject
    lateinit var logger: Logger
    @Inject
    lateinit var locationProvider: LocationProvider


    private val onLocationPermissionListener = object : OnPermissionListener {
        override fun onPermissionGranted() {
            requestLocation()
        }

        override fun onPermissionDeclined() {
            println("onPermissionDeclined")
        }
    }

    init {
        DiManager.getAppComponent().inject(this)
    }

    private fun requestLocation() {
        locationProvider.requestLocation()
    }

    override fun onFirstViewAttach() {
    }

    fun onMapReady(googleMap: GoogleMap) {
        viewState.requestPermission(LocationManager.NETWORK_PROVIDER, onLocationPermissionListener)
    }
}
