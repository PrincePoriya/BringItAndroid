package com.android.bringit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.bringit.R
import com.android.bringit.databinding.ItemAddressBinding
import com.android.bringit.model.AddressItem

class AddressAdapter(
    private var addressList: List<AddressItem>,
    private val onItemSelected: (Int) -> Unit
) : RecyclerView.Adapter<AddressAdapter.AddressViewHolder>() {

    private var selectedPosition: Int = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressViewHolder {
        val binding = ItemAddressBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AddressViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AddressViewHolder, position: Int) {
        val item = addressList[position]
        holder.bind(item, position)
    }

    override fun getItemCount(): Int = addressList.size

    inner class AddressViewHolder(private val binding: ItemAddressBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: AddressItem, position: Int) {
            binding.txtLabel.text = item.label + " :"
            binding.txtAddress.text = item.address

            if (position == selectedPosition) {
                binding.cardView.setBackgroundResource(R.drawable.selected_bg)  // Selected background
                binding.imgCheck.visibility = View.VISIBLE  // Show check icon
                binding.icSelected.visibility = View.VISIBLE  // Show check icon
            } else {
                binding.cardView.setBackgroundResource(R.drawable.unselected_bg) // Normal background
                binding.imgCheck.visibility = View.GONE  // Hide check icon
                binding.icSelected.visibility = View.GONE  // Hide check icon
            }

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