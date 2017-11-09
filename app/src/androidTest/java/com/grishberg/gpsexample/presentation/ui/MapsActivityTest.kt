package com.grishberg.gpsexample.presentation.ui

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import com.grishberg.gpsexample.ClearData


/**
 * Created by grishberg on 16.10.17.
 */
@RunWith(AndroidJUnit4::class)
class MapsActivityTest {
    @Test
    @Throws(Exception::class)
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()

        assertEquals("com.grishberg.gpsexample", appContext.packageName)
    }

    @Test
    @ClearData
    @Throws(Exception::class)
    fun testLifeCycleCreate() {
        val appContext = InstrumentationRegistry.getTargetContext()
        val intent = Intent(appContext, MapsActivity::class.java)

        startActivity(appContext, intent, null)
    }
}