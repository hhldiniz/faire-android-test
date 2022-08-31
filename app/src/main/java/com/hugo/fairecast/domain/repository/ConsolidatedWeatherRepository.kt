package com.hugo.fairecast.domain.repository

import com.hugo.fairecast.app.presentation.ForecastPresentation
import com.hugo.fairecast.app.presentation.NextDaysForecastPresentation
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
                            weatherInfo.weatherStateAbbr,
                            consolidatedWeather.weatherInfo.subList(
                                0,
                                consolidatedWeather.weatherInfo.lastIndex
                            ).map { nextDaysInfo ->
                                NextDaysForecastPresentation(
                                    nextDaysInfo.weatherStateName,
                                    nextDaysInfo.minTemp,
                                    nextDaysInfo.maxTemp,
                                    nextDaysInfo.theTemp,
                                    nextDaysInfo.weatherStateAbbr,
                                    nextDaysInfo.applicableDate
                                )
                            }
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