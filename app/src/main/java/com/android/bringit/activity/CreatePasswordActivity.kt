package com.android.bringit.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.bringit.R
import com.android.bringit.databinding.ActivityCreatePasswordBinding

class CreatePasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreatePasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCreatePasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}