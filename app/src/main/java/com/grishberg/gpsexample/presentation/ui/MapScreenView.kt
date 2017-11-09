package com.grishberg.gpsexample.presentation.ui

import com.arellomobile.mvp.MvpView
import com.grishberg.gpsexample.presentation.ui.common.OnPermissionListener

/**
 * Created by grishberg on 09.11.17.
 */
interface MapScreenView : MvpView {
    fun requestPermission(permission: String, callback: OnPermissionListener)
}