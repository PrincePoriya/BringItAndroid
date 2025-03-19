package com.android.bringit.activity

import android.os.Bundle
import com.android.bringit.base.BaseActivity
import com.android.bringit.databinding.ActivityOrderBinding

class OrderActivity : BaseActivity() {

    private lateinit var binding: ActivityOrderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgBack.setOnClickListener {
            finish()
        }
    }
}