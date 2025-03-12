package com.android.bringit.activity

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.bringit.R
import com.android.bringit.adapter.CountryAdapter
import com.android.bringit.base.BaseActivity
import com.android.bringit.databinding.ActivitySignupBinding
import com.android.bringit.model.Country
import com.google.android.material.snackbar.Snackbar

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

            //performNext()

            startActivity(Intent(this@SignupActivity,CreatePasswordActivity::class.java))
        }

        binding.txtLogin.setOnClickListener {
            finish()
        }

        binding.txtCountryCode.setOnClickListener {
            showCountryPicker(this) { selectedCountry ->
                binding.txtCountryCode.text = selectedCountry.code
                //binding.edtMobileNumber.text = selectedCountry.name
            }
        }
    }

    private fun showCountryPicker(context: Context, onSelect: (Country) -> Unit) {

        val countryList = listOf(
            Country("India", "+91", "IN"),
            Country("United States", "+1", "US"),
            Country("United Kingdom", "+44", "UK"),
            Country("Canada", "+1", "CA"),
            Country("Australia", "+61", "AU"),
            Country("Germany", "+49", "DE"),
            Country("France", "+33", "FR"),
            Country("Japan", "+81", "JP"),
            Country("China", "+86", "CN"),
            Country("Brazil", "+55", "BR")
        )

        val dialog = Dialog(context)
        dialog.setContentView(R.layout.dialog_country_picker)
        dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)

        val recyclerView = dialog.findViewById<RecyclerView>(R.id.rv_countries)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = CountryAdapter(countryList) {
            onSelect(it)
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun performNext() {
        val edtFirstName = binding.edtFirstName.text.toString().trim()
        val edtLastName = binding.edtLastName.text.toString().trim()
        val edtEmailAddress = binding.edtEmailAddress.text.toString().trim()
        val edtMobileNumber = binding.edtMobileNumber.text.toString().trim()

        if (edtFirstName.isEmpty()) {
            Snackbar.make(binding.root, "Please enter first name", Snackbar.LENGTH_SHORT).show()
            return
        }

        if (edtLastName.isEmpty()) {
            Snackbar.make(binding.root, "Please enter last name", Snackbar.LENGTH_SHORT).show()
            return
        }

        if (edtEmailAddress.isEmpty()) {
            Snackbar.make(binding.root, "Please enter email address", Snackbar.LENGTH_SHORT).show()
            return
        }

        if (edtEmailAddress.isEmpty()) {
            Snackbar.make(binding.root, "Please enter email address", Snackbar.LENGTH_SHORT).show()
            return
        }

        if (edtMobileNumber.isEmpty()) {
            Snackbar.make(binding.root, "Please enter mobile number", Snackbar.LENGTH_SHORT).show()
            return
        }

        // Implement login logic (API call, authentication, etc.)
    }

}