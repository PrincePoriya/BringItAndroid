package com.android.bringit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.bringit.R
import com.android.bringit.databinding.ItemAddressBinding
import com.android.bringit.databinding.ItemTransactionHistoryBinding
import com.android.bringit.model.AddressItem

class TransactionListAdapter(
    private var addressList: List<AddressItem>,
    private val onItemSelected: (Int) -> Unit
) : RecyclerView.Adapter<TransactionListAdapter.AddressViewHolder>() {

    private var selectedPosition: Int = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressViewHolder {
        val binding = ItemTransactionHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AddressViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AddressViewHolder, position: Int) {
        val item = addressList[position]
        holder.bind(item, position)
    }

    override fun getItemCount(): Int = addressList.size

    inner class AddressViewHolder(private val binding: ItemTransactionHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: AddressItem, position: Int) {
            binding.txtLabel.text = item.label + " :"


            binding.root.setOnClickListener {
                val previousSelected = selectedPosition
                selectedPosition = position
                notifyItemChanged(previousSelected)  // Update previous selection
                notifyItemChanged(selectedPosition)  // Update new selection
                onItemSelected(selectedPosition)
            }
        }
    }
}