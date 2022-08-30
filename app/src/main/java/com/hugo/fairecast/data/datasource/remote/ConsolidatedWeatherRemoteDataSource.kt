package com.hugo.fairecast.data.datasource.remote

import com.hugo.fairecast.data.datasource.ConsolidatedWeatherDataSource
import com.hugo.fairecast.data.services.ForecastService
import kotlinx.coroutines.flow.flow

class ConsolidatedWeatherRemoteDataSource(
    private val service: ForecastService
) : ConsolidatedWeatherDataSource {

    override suspend fun getForecastByCityId(id: Int) =
        flow { emit(service.listRepos(id).body()) }
}