package com.hugo.fairecast.app.presentation

data class ForecastPresentation(
    val cityName: String,
    val weatherState: String,
    val minTemp: String,
    val maxTemp: String,
    val theTemp: String
)