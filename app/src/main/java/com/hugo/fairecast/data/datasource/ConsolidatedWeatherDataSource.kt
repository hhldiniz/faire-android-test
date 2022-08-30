package com.hugo.fairecast.data.datasource

import com.hugo.fairecast.domain.models.ConsolidatedWeather
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinComponent

interface ConsolidatedWeatherDataSource: KoinComponent {
        suspend fun getForecastByCityId(id: Int): Flow<ConsolidatedWeather?>
}