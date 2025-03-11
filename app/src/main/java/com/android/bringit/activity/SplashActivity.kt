package com.android.bringit.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.android.bringit.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private lateinit var splashScreen: SplashScreen
    override fun onCreate(savedInstanceState: Bundle?) {
        splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        migrateNotificationPermissions()
        splashScreen.setKeepOnScreenCondition { true }
        toNextScreen()
    }

    private fun migrateNotificationPermissions() {
        /*if (Build.VERSION.SDK_INT >= 33) {
            if (!Hawk.get(IS_NOTIFICATION_MIGRATE, false)) {
                if (ContextCompat.checkSelfPermission(this@SplashActivity, Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED) {
                    Hawk.put(IS_NOTIFICATION_ENABLED, true)
                } else {
                    Hawk.put(IS_NOTIFICATION_ENABLED, false)
                }
                Hawk.put(IS_NOTIFICATION_MIGRATE, true)
                OneSignal.disablePush(!Hawk.get(IS_NOTIFICATION_ENABLED, false))
            }
        }*/
    }


    private fun toNextScreen() {
         startActivity(Intent(this@SplashActivity,LoginActivity::class.java))
    }


}