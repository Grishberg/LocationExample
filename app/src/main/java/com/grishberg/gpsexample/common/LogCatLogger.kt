package com.grishberg.gpsexample.common

import android.util.Log

/**
 * Created by grishberg on 09.11.17.
 */
class LogCatLogger : Logger {
    override fun d(tag: String, msg: String) {
        Log.d(tag, msg)
    }

    override fun e(tag: String, msg: String) {
        Log.e(tag, msg)
    }

    override fun e(tag: String, msg: String, t: Throwable) {
        Log.e(tag, msg, t)
    }
}