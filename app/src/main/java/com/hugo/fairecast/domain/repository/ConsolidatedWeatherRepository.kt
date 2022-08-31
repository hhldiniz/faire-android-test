package com.hugo.fairecast.domain.repository

import com.hugo.fairecast.app.presentation.ForecastPresentation
import com.hugo.fairecast.app.view.states.ForecastInfoState
import com.hugo.fairecast.data.datasource.remote.ConsolidatedWeatherRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ConsolidatedWeatherRepository(
    private val consolidatedWeatherRemoteDataSource: ConsolidatedWeatherRemoteDataSource
) {

    suspend fun getForecastByCityId(id: Int): Flow<ForecastInfoState> {
        return consolidatedWeatherRemoteDataSource.getForecastByCityId(id).map {
            if (it.isSuccessful) {
                val consolidatedWeather = it.body()
                if (consolidatedWeather != null) {
                    val weatherInfo = consolidatedWeather.weatherInfo[0]
                    ForecastInfoState.Success(
                        ForecastPresentation(
                            consolidatedWeather.title,
                            weatherInfo.weatherStateName,
                            weatherInfo.minTemp,
                            weatherInfo.maxTemp,
                            weatherInfo.theTemp,
                            weatherInfo.weatherStateAbbr
                        )
                    )
                } else
                    ForecastInfoState.Error("Data is empty")
            } else {
                ForecastInfoState.Error(it.message())
            }
        }
    }
}