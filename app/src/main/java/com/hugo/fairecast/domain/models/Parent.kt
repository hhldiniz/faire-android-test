package com.hugo.fairecast.domain.models

import com.google.gson.annotations.SerializedName

data class Parent(
    val title: String,
    @SerializedName("location_type")
    val locationType: String,
    val woeid: Int,
    @SerializedName("lat_long")
    val latLong: String
)