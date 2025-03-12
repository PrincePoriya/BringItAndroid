package com.android.bringit.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.android.bringit.R
import com.android.bringit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var isDeliverySelected = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.unselectDelivery.setOnClickListener {
           isDeliverySelected = true
           binding.selectDriver.visibility = View.GONE
           binding.unselectDriver.visibility = View.VISIBLE
           binding.unselectDelivery.visibility = View.GONE
           binding.selectDelivery.visibility = View.VISIBLE

           binding.txtUnselectDelivery.setTextColor(ContextCompat.getColor(this, R.color.white))
           binding.txtSelectDriver.setTextColor(ContextCompat.getColor(this, R.color.color_999999))

        }

        binding.unselectDriver.setOnClickListener {
            isDeliverySelected = false
            binding.selectDriver.visibility = View.VISIBLE
            binding.unselectDriver.visibility = View.GONE
            binding.unselectDelivery.visibility = View.VISIBLE
            binding.selectDelivery.visibility = View.GONE

            binding.txtUnselectDelivery.setTextColor(ContextCompat.getColor(this, R.color.color_999999))
            binding.txtSelectDriver.setTextColor(ContextCompat.getColor(this, R.color.black))

        }

        binding.cardUseYourCar.setOnClickListener {
            if(isDeliverySelected){
                startActivity(Intent(this@MainActivity,DriverActivity::class.java))
            }else{
                startActivity(Intent(this@MainActivity,UserActivity::class.java))
            }
        }
    }
}