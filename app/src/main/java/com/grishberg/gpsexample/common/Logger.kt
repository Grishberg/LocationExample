package com.grishberg.gpsexample.common

/**
 * Created by grishberg on 09.11.17.
 */
interface Logger {
    fun d(tag: String, msg: String)
    fun e(tag: String, msg: String)
    fun e(tag: String, msg: String, t: Throwable)
}