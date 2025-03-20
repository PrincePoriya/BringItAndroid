package com.android.bringit.activity

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.bringit.adapter.TransactionListAdapter
import com.android.bringit.base.BaseActivity
import com.android.bringit.databinding.ActivityTransactionHistoryBinding
import com.android.bringit.model.AddressItem

class TransactionHistoryActivity : BaseActivity() {

    private lateinit var binding: ActivityTransactionHistoryBinding

    private lateinit var transactionListAdapter: TransactionListAdapter

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

        binding = ActivityTransactionHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgBack.setOnClickListener {
            finish()
        }
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        transactionListAdapter = TransactionListAdapter(addressList) { selectedPosition ->

        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = transactionListAdapter
    }
}