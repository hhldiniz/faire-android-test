package com.hugo.fairecast.modules

import com.hugo.fairecast.data.datasource.remote.ConsolidatedWeatherRemoteDataSource
import org.koin.core.qualifier.TypeQualifier
import org.koin.dsl.module

private val consolidatedWeatherDataSourceModules = module {
    single(
        qualifier = TypeQualifier(
            ConsolidatedWeatherRemoteDataSource::class
        )
    ) {
        ConsolidatedWeatherRemoteDataSource(get())
    }
}

val dataSourceModules = arrayOf(consolidatedWeatherDataSourceModules)