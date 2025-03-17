package com.android.bringit.activity

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.bringit.adapter.AddressAdapter
import com.android.bringit.base.BaseActivity
import com.android.bringit.databinding.ActivitySelectAddressBinding
import com.android.bringit.model.AddressItem

class SelectAddressActivity : BaseActivity() {

    private lateinit var binding: ActivitySelectAddressBinding

    private lateinit var type: String

    private lateinit var adapter: AddressAdapter
    private var addressList = mutableListOf(
        AddressItem("Home", "Geb. 571, CargoCity Süd, 60549 Frankfurt am Main, Germany"),
        AddressItem("Office", "Industriestraße 100-102, 21107 Hamburg, Germany"),
        AddressItem("Mall", "Am Flughafen 12, 60549 Frankfurt am Main, Germany"),
        AddressItem(
            "Other Home",
            "Airport Trade Center, Wanheimer Str. 90, 40468 Düsseldorf, Germany"
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySelectAddressBinding.inflate(layoutInflater)
        setContentView(binding.root)

        type = intent.getStringExtra("type").toString()

        binding.imgBack.setOnClickListener {
            finish()
        }
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        adapter = AddressAdapter(addressList) { selectedPosition ->
            // Handle selected item
            val intent = Intent(this@SelectAddressActivity, DeliveryDetailActivity::class.java)
            intent.putExtra("type", type)
            startActivity(intent)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }
}