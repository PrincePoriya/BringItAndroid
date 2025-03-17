package com.android.bringit.activity

import android.os.Bundle
import com.android.bringit.base.BaseActivity
import com.android.bringit.databinding.ActivityItemDetailBinding

class ItemDetailActivity : BaseActivity() {

    private lateinit var binding: ActivityItemDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityItemDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgBack.setOnClickListener {
            finish()
        }

    }
}