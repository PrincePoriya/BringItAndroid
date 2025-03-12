package com.android.bringit.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.bringit.databinding.ActivityCreatePasswordBinding
import com.google.android.material.snackbar.Snackbar

class CreatePasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreatePasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCreatePasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.cardCreateAccount.setOnClickListener {
            //performLogin()
            startActivity(Intent(this@CreatePasswordActivity,MainActivity::class.java))
            finish()
        }

    }

    private fun performLogin() {
        val edtConfirmPassword = binding.edtConfirmPassword.text.toString().trim()
        val edtPassword = binding.edtPassword.text.toString().trim()

        if (edtPassword.isEmpty()) {
            Snackbar.make(binding.root, "Please enter password", Snackbar.LENGTH_SHORT).show()
            return
        }

        if (edtConfirmPassword.isEmpty()) {
            Snackbar.make(binding.root, "Please enter confirm password", Snackbar.LENGTH_SHORT).show()
            return
        }

        // Implement login logic (API call, authentication, etc.)
    }
}