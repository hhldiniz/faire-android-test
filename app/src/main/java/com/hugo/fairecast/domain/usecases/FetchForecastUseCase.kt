package com.hugo.fairecast.domain.usecases

import com.hugo.fairecast.app.view.states.ForecastInfoState
import com.hugo.fairecast.domain.repository.ConsolidatedWeatherRepository
import kotlinx.coroutines.flow.Flow

class FetchForecastUseCase(
    private val consolidatedWeatherRepository: ConsolidatedWeatherRepository
) {
    suspend fun getForecast(cityId: Int): Flow<ForecastInfoState> {
        return consolidatedWeatherRepository.getForecastByCityId(cityId)
    }
}