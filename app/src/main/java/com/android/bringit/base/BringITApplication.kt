package com.android.bringit.base

import android.app.Application
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.widget.Toast
import com.android.bringit.helper.NetworkChangeReceiver

import com.orhanobut.hawk.BuildConfig
import com.orhanobut.hawk.Hawk

import dagger.hilt.android.HiltAndroidApp
import org.greenrobot.eventbus.EventBus
import java.util.concurrent.atomic.AtomicInteger


@HiltAndroidApp
class BringITApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
        EventBus.builder().throwSubscriberException(BuildConfig.DEBUG).installDefaultEventBus()
        Hawk.init(this).build()

        registerReceiver(NetworkChangeReceiver(), IntentFilter().apply {
            addAction(ConnectivityManager.CONNECTIVITY_ACTION)
        })
    }


    override fun onTerminate() {
        super.onTerminate()
        unregisterReceiver(NetworkChangeReceiver())
    }


    companion object {
        var instance: BringITApplication? = null

        var toast: Toast? = null
        var isSyncInProgress: Boolean = false
        var nointernet: Toast? = null
        var RESOURCE_DEFAULT_PATH = ""
        var FONT_DEFAULT_PATH = ""
        private var atomicInteger: AtomicInteger = AtomicInteger(0)
        fun getNextUniqueValue(): Int {
            return (System.currentTimeMillis() + atomicInteger.incrementAndGet()).toInt()
        }

        @JvmName("getInstance1")
        fun getInstance(): BringITApplication? {
            return instance
        }
    }

}