package com.android.bringit.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.bringit.databinding.ActivityRecipientDetailsBinding

class RecipientDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecipientDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRecipientDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgBack.setOnClickListener {
            finish()
        }

        binding.cardNextButton.setOnClickListener {
            val intent = Intent(this@RecipientDetailsActivity, ReviewOrderActivity::class.java)
            intent.putExtra("type", "")
            startActivity(intent)
        }
    }
}