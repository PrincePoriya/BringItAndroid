package com.android.bringit.model

data class AddressItem(
    val label: String,
    val address: String,
    var isSelected: Boolean = false
)