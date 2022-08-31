package com.hugo.fairecast.app.presentation

data class ForecastPresentation(
    val cityName: String,
    val weatherState: String,
    val minTemp: Float,
    val maxTemp: Float,
    val theTemp: Float,
    val weatherStateAbr: String
)