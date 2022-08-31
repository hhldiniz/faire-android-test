package com.hugo.fairecast.app.viewmodel

import androidx.lifecycle.ViewModel
import com.hugo.fairecast.app.view.states.ForecastInfoState
import com.hugo.fairecast.domain.usecases.FetchForecastUseCase
import kotlinx.coroutines.flow.Flow

class ForecastInfoViewModel(
    private val fetchForecastUseCase: FetchForecastUseCase
) : ViewModel() {

    suspend fun getForecastByCityId(id: Int): Flow<ForecastInfoState> {
        return fetchForecastUseCase.getForecast(id)
    }
}