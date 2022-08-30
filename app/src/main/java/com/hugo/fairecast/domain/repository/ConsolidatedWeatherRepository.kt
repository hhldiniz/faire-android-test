package com.hugo.fairecast.domain.repository

import com.hugo.fairecast.data.datasource.remote.ConsolidatedWeatherRemoteDataSource
import com.hugo.fairecast.domain.models.ConsolidatedWeather
import kotlinx.coroutines.flow.Flow

class ConsolidatedWeatherRepository(
    private val consolidatedWeatherRemoteDataSource: ConsolidatedWeatherRemoteDataSource
)  {

    suspend fun getForecastByCityId(id: Int): Flow<ConsolidatedWeather?> {
        return consolidatedWeatherRemoteDataSource.getForecastByCityId(id)
    }
}