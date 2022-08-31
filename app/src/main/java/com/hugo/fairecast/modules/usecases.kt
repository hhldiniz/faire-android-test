package com.hugo.fairecast.modules

import com.hugo.fairecast.domain.usecases.FetchForecastUseCase
import org.koin.dsl.module

private val fetchForecastUseCaseModules = module {
    single {
        FetchForecastUseCase(get())
    }
}

val useCaseModules = arrayOf(fetchForecastUseCaseModules)