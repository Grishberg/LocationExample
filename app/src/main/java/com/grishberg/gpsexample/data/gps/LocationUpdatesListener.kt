package com.grishberg.gpsexample.data.gps

import android.location.Location

/**
 * Created by grishberg on 01.11.17.
 */
interface LocationUpdatesListener {
    fun onLocationReceived(location: Location)
}