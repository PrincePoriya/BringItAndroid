package com.android.bringit.activity

import android.content.Intent
import android.os.Bundle
import com.android.bringit.base.BaseActivity
import com.android.bringit.databinding.ActivityReviewOrderBinding

class ReviewOrderActivity : BaseActivity() {

    private lateinit var binding: ActivityReviewOrderBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityReviewOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgBack.setOnClickListener {
            finish()
        }

        binding.crdConfirm.setOnClickListener {
            val intent = Intent(this@ReviewOrderActivity, ItemDetailActivity::class.java)
            intent.putExtra("type", "")
            startActivity(intent)
        }

    }
}