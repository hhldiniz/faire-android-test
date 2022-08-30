package com.hugo.fairecast.domain.models

import com.google.gson.annotations.SerializedName

data class ConsolidatedWeather(
    @SerializedName("consolidated_weather")
    val weatherInfo: List<WeatherInfo>,
    val parent: Parent,
    val title: String,
    @SerializedName("location_type")
    val locationType: String
)