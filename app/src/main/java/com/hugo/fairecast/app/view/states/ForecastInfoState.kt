package com.hugo.fairecast.app.view.states

import com.hugo.fairecast.app.presentation.ForecastPresentation

sealed class ForecastInfoState {
    data class Success(val presentation: ForecastPresentation): ForecastInfoState()
    data class Error(val message: String): ForecastInfoState()
    object Loading: ForecastInfoState()
    object Empty: ForecastInfoState()
}
