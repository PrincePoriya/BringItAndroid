package com.android.bringit.activity

import android.os.Bundle
import android.text.InputType
import com.android.bringit.R
import com.android.bringit.base.BaseActivity
import com.android.bringit.databinding.ActivityLoginBinding
import com.google.android.material.snackbar.Snackbar

class LoginActivity : BaseActivity() {

    private lateinit var binding: ActivityLoginBinding
    private var isPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        binding.icPasswordToggle.setOnClickListener {
            togglePasswordVisibility()
        }

        binding.cardLoginButton.setOnClickListener {
            performLogin()
        }

        binding.txtSignup.setOnClickListener {
            navigateToSignup()
        }

        // Move focus to password field when pressing Enter on email field
        binding.edtEmail.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == android.view.inputmethod.EditorInfo.IME_ACTION_NEXT) {
                binding.edtPassword.requestFocus()
                true
            } else {
                false
            }
        }

        // Perform login when pressing Enter on password field
        binding.edtPassword.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == android.view.inputmethod.EditorInfo.IME_ACTION_DONE) {
                performLogin()
                true
            } else {
                false
            }
        }
    }

    private fun togglePasswordVisibility() {
        if (isPasswordVisible) {
            binding.edtPassword.inputType =
                InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            binding.icPasswordToggle.setImageResource(R.drawable.ic_pass_visible)
        } else {
            binding.edtPassword.inputType =
                InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            binding.icPasswordToggle.setImageResource(R.drawable.ic_pass_invisible)
        }
        binding.edtPassword.setSelection(binding.edtPassword.text?.length ?: 0)
        isPasswordVisible = !isPasswordVisible
    }

    private fun performLogin() {
        val email = binding.edtEmail.text.toString().trim()
        val password = binding.edtPassword.text.toString().trim()

        if (email.isEmpty()) {
            Snackbar.make(binding.root, "Please enter email", Snackbar.LENGTH_SHORT).show()
            return
        }

        if (password.isEmpty()) {
            Snackbar.make(binding.root, "Please enter password", Snackbar.LENGTH_SHORT).show()
            return
        }

        // Implement login logic (API call, authentication, etc.)
    }


    private fun navigateToSignup() {
        // Navigate to Signup Activity or Fragment
    }
}


