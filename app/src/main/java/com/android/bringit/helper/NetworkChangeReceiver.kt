package com.android.bringit.helper

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.android.bringit.model.EventModel
import com.android.bringit.utils.EventType
import org.greenrobot.eventbus.EventBus

class NetworkChangeReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        try {
            NetworkUtil.hasInternetConnection(context)
            EventBus.getDefault().post(EventModel(EventType.NETWORK_EVENT, null, NetworkUtil.hasInternetConnection(context)))
        } catch (e: NullPointerException) {
            e.printStackTrace()
        }
    }
}