package com.android.bringit.activity

import android.content.Intent
import android.os.Bundle
import com.android.bringit.base.BaseActivity
import com.android.bringit.databinding.ActivityDeliveryDetailBinding

class DeliveryDetailActivity : BaseActivity() {

    private lateinit var binding: ActivityDeliveryDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDeliveryDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgBack.setOnClickListener {
            finish()
        }

        binding.txtTapToAdd.setOnClickListener {
            val intent = Intent(this@DeliveryDetailActivity, DeliveryDetailActivity::class.java)
            intent.putExtra("type", "")
            startActivity(intent)
        }

        binding.crdAddItemDetail.setOnClickListener {
            val intent = Intent(this@DeliveryDetailActivity, ItemDetailActivity::class.java)
            intent.putExtra("type", "")
            startActivity(intent)
        }
    }
}