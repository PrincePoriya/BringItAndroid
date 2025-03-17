package com.android.bringit.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.android.bringit.R
import com.android.bringit.base.BaseActivity
import com.android.bringit.databinding.ActivityUserBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class UserActivity : BaseActivity(), OnMapReadyCallback {

    private lateinit var binding: ActivityUserBinding
    private lateinit var googleMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val mapFragment = supportFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync(this)


        binding.imgBack.setOnClickListener {
            finish()
        }

        binding.cardSelectAddressButton.setOnClickListener {
            startActivity(Intent(this@UserActivity,SelectCategoryActivity::class.java))
        }

        binding.crdUnSelectHome.setOnClickListener {



            binding.crdHome.visibility = View.VISIBLE
            binding.crdUnSelectHome.visibility = View.GONE

            binding.crdSelectOffice.visibility = View.GONE
            binding.crdOffice.visibility = View.VISIBLE

            binding.crdSelectMall.visibility = View.GONE
            binding.crdMall.visibility = View.VISIBLE

        }

        binding.crdOffice.setOnClickListener {
            binding.crdHome.visibility = View.GONE
            binding.crdUnSelectHome.visibility = View.VISIBLE

            binding.crdSelectOffice.visibility = View.VISIBLE
            binding.crdOffice.visibility = View.GONE

            binding.crdSelectMall.visibility = View.GONE
            binding.crdMall.visibility = View.VISIBLE

        }

        binding.crdMall.setOnClickListener {
            binding.crdHome.visibility = View.GONE
            binding.crdUnSelectHome.visibility = View.VISIBLE

            binding.crdSelectOffice.visibility = View.GONE
            binding.crdOffice.visibility = View.VISIBLE

            binding.crdSelectMall.visibility = View.VISIBLE
            binding.crdMall.visibility = View.GONE

        }
    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map

        // Example: Add a marker at a specific location
        val location = LatLng(37.7749, -122.4194) // San Francisco
        googleMap.addMarker(MarkerOptions().position(location).title("San Francisco"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 12f)) // Zoom level: 12
    }
}