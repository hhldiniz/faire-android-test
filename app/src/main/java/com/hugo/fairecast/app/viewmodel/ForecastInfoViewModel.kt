package com.hugo.fairecast.app.viewmodel

import androidx.lifecycle.ViewModel
import com.hugo.fairecast.app.view.states.ForecastInfoState
import com.hugo.fairecast.domain.repository.ConsolidatedWeatherRepository
import kotlinx.coroutines.flow.Flow

class ForecastInfoViewModel(
    private val consolidatedWeatherRepository: ConsolidatedWeatherRepository
) : ViewModel() {

    suspend fun getForecastByCityId(id: Int): Flow<ForecastInfoState> {
        return consolidatedWeatherRepository.getForecastByCityId(id)
    }
}