package com.android.bringit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.bringit.R
import com.android.bringit.model.Country

class CountryAdapter(
    private val countries: List<Country>,
    private val onSelect: (Country) -> Unit
) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    inner class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvCountryName: TextView = itemView.findViewById(R.id.tv_country_name)
        val tvCountryCode: TextView = itemView.findViewById(R.id.tv_country_code)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_country, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = countries[position]
        holder.tvCountryName.text = country.name
        holder.tvCountryCode.text = country.code

        holder.itemView.setOnClickListener {
            onSelect(country)
        }
    }

    override fun getItemCount(): Int = countries.size
}