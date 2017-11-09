package com.grishberg.gpsexample.data.gps

import android.content.Context
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.location.LocationListener





/**
 * Created by grishberg on 02.11.17.
 */
class LocationProviderImpl : LocationProvider {
    val locationManager: LocationManager
    val locationObservers: ArrayList<LocationUpdatesListener> = ArrayList()

    val locationListener = object : LocationListener {
        override fun onLocationChanged(location: Location) {
            // Called when a new location is found by the network location provider.
            notifyLocationUpdates(location)
        }

        override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}

        override fun onProviderEnabled(provider: String) {}

        override fun onProviderDisabled(provider: String) {}
    }

    constructor(context: Context) {
        locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    }

    fun notifyLocationUpdates(location: Location) {
        for (listener in locationObservers) {
            listener.onLocationReceived(location)
        }
    }

    override fun requestLocation() {
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
                0L, 0f, locationListener)
    }
}