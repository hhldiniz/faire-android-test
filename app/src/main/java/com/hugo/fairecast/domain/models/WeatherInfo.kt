package com.hugo.fairecast.domain.models

import com.google.gson.annotations.SerializedName

data class WeatherInfo(
    val id: Long,
    @SerializedName("weather_state_name")
    val weatherStateName: String,
    @SerializedName("weather_state_abbr")
    val weatherStateAbbr: String,
    @SerializedName("wind_direction_compass")
    val windDirectionCompass: String,
    val created: String,
    @SerializedName("applicable_date")
    val applicableDate: String,
    @SerializedName("min_temp")
    val minTemp: Float,
    @SerializedName("max_temp")
    val maxTemp: Float,
    @SerializedName("the_temp")
    val theTemp: Float,
    @SerializedName("wind_speed")
    val windSpeed: Float,
    @SerializedName("wind_direction")
    val windDirection: Float,
    @SerializedName("air_pressure")
    val airPressure: Float,
    val humidity: Int,
    val visibility: Float,
    val predictability: Int
)