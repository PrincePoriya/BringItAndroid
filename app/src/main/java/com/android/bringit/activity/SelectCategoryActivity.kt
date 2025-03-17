package com.android.bringit.activity
import android.content.Intent
import android.os.Bundle
import com.android.bringit.base.BaseActivity
import com.android.bringit.databinding.ActivitySelectCategoryBinding

class SelectCategoryActivity : BaseActivity() {

    private lateinit var binding: ActivitySelectCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySelectCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgBack.setOnClickListener {
            finish()
        }

        binding.llBriefKlein.setOnClickListener {
            openSelectAddressActivity("BriefKlein")
        }
        binding.llBriefGross.setOnClickListener {
            openSelectAddressActivity("BriefGross")
        }
        binding.llPaketKlein.setOnClickListener {
            openSelectAddressActivity("PaketKlein")
        }
        binding.llViewAll.setOnClickListener {
            openSelectAddressActivity("Other")
        }
    }

    private fun openSelectAddressActivity(type: String) {
        val intent = Intent(this@SelectCategoryActivity, SelectAddressActivity::class.java)
        intent.putExtra("type", type)
        startActivity(intent)
    }
}