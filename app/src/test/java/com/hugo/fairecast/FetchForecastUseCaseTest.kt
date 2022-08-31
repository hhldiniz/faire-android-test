package com.hugo.fairecast

import com.hugo.fairecast.app.view.states.ForecastInfoState
import com.hugo.fairecast.domain.usecases.FetchForecastUseCase
import com.hugo.fairecast.modules.dataSourceModules
import com.hugo.fairecast.modules.repositoryModules
import com.hugo.fairecast.modules.serviceModules
import com.hugo.fairecast.modules.useCaseModules
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.test.KoinTest
import org.koin.test.inject

class FetchForecastUseCaseTest: KoinTest {

    private val fetchForecastUseCase: FetchForecastUseCase by inject()

    @Test
    fun checkIfFetchDataIsSuccessful() = runBlocking {
        startKoin {
            modules(
                *serviceModules,
                *dataSourceModules,
                *repositoryModules,
                *useCaseModules
            )
        }
        val state = fetchForecastUseCase.getForecast(4418)
        state.collect {
            assert(it is ForecastInfoState.Success)
        }
    }

    @Test
    fun checkIfFetchDataIsError() = runBlocking {
        startKoin {
            modules(
                *serviceModules,
                *dataSourceModules,
                *repositoryModules,
                *useCaseModules
            )
        }
        val state = fetchForecastUseCase.getForecast(4481) // Invalid id
        state.collect {
            assert(it is ForecastInfoState.Error)
        }
    }
}