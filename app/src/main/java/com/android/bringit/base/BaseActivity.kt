package com.android.bringit.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineExceptionHandler


open class BaseActivity : AppCompatActivity() {

    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
    }

    override fun onResume() {
        migrateNotificationsPermissions()
        super.onResume()
    }

    private fun migrateNotificationsPermissions() {
        /*if (Build.VERSION.SDK_INT >= 33) {
            if (ContextCompat.checkSelfPermission(this@BaseActivity, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                if (Hawk.get(IS_NOTIFICATION_ENABLED, false)) {
                    Hawk.put(IS_NOTIFICATION_ENABLED, false)
                    OneSignal.disablePush(!Hawk.get(IS_NOTIFICATION_ENABLED, false))
                }
            }
        }*/
    }

    open fun replaceFragmentMain(
        fragment: Fragment,
        frame: Int,
        isBackStack: Boolean,
        bundle: Bundle? = null,
    ) {
        try {
            if (bundle != null) fragment.arguments = bundle
            val trans = supportFragmentManager.beginTransaction()
            trans.replace(
                frame, fragment, fragment.javaClass.simpleName.toString()
            )
            if (isBackStack) trans.addToBackStack(javaClass.simpleName.toString())
            trans.commit()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}