package com.android.bringit.activity

import android.content.Intent
import android.os.Bundle
import com.android.bringit.base.BaseActivity
import com.android.bringit.databinding.ActivitySignupBinding

class SignupActivity : BaseActivity() {

    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        binding.cardNextButton.setOnClickListener {
            startActivity(Intent(this@SignupActivity,CreatePasswordActivity::class.java))
        }

        binding.txtLogin.setOnClickListener {
            finish()
        }
    }
}