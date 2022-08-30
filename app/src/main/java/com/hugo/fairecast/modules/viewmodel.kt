package com.hugo.fairecast.modules

import com.hugo.fairecast.app.viewmodel.ForecastInfoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val forecastInfoFragmentModules = module {
    viewModel {
        ForecastInfoViewModel(get())
    }
}

val viewModelModules = arrayOf(forecastInfoFragmentModules)