package com.android.bringit.activity

import android.os.Bundle
import com.android.bringit.base.BaseActivity
import com.android.bringit.databinding.ActivityConfirmBookingBinding

class ConfirmBookingActivity : BaseActivity() {

    private lateinit var binding: ActivityConfirmBookingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityConfirmBookingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgBack.setOnClickListener {
            finish()
        }
    }
}