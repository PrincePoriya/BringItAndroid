package com.android.bringit.model

import android.os.Parcelable
import com.android.bringit.utils.EventType
import kotlinx.parcelize.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class EventModel(
    var eventName: EventType, var data: @RawValue Any?, var needUpdate: Boolean = false
) : Parcelable
