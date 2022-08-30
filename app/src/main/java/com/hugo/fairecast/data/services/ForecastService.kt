package com.hugo.fairecast.data.services

import com.hugo.fairecast.domain.models.ConsolidatedWeather
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface ForecastService {
    @GET("{locationId}.json")
    suspend fun listRepos(@Path("locationId") locationId: Int): Response<ConsolidatedWeather>
}