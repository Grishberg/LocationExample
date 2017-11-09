package com.grishberg.gpsexample.presentation.ui

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.grishberg.gpsexample.R
import com.grishberg.gpsexample.presentation.presenter.MapPresenter
import com.grishberg.gpsexample.presentation.ui.common.BaseActivity
import com.grishberg.gpsexample.presentation.ui.common.OnPermissionListener

class MapsActivity : BaseActivity(), OnMapReadyCallback, MapScreenView {

    @InjectPresenter
    lateinit var presenter: MapPresenter

    private var mMap: GoogleMap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        presenter.onMapReady(googleMap)

        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap!!.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap!!.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }

    override fun requestPermission(permission: String, callback: OnPermissionListener) {
        checkPermission(permission, callback)
    }
}
