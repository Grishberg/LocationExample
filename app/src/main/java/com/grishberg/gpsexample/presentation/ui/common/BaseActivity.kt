package com.grishberg.gpsexample.presentation.ui.common

import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import com.arellomobile.mvp.MvpAppCompatActivity

/**
 * Created by grishberg on 02.11.17.
 */
open class BaseActivity : MvpAppCompatActivity {
    constructor() : super()

    private var requestCode: Int = 0
    private val permissionListeners = HashMap<Int, OnPermissionListener>()

    fun checkPermission(permission: String, permissionListener: OnPermissionListener) {
        if (ContextCompat.checkSelfPermission(this, permission)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, permission)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                permissionListener.onPermissionDeclined()

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this, arrayOf(permission), requestCode)

                permissionListeners.put(requestCode++, permissionListener)
            }
        } else {
            permissionListener.onPermissionGranted()
        }

    }

    /**
     * TODO: check multiple results
     */
    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<out String>,
                                            grantResults: IntArray) {
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            permissionListeners[requestCode]?.onPermissionGranted()
        } else {
            permissionListeners[requestCode]?.onPermissionDeclined()
        }
    }

}