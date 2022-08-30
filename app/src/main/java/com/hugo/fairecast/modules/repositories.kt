package com.hugo.fairecast.modules

import com.hugo.fairecast.data.datasource.remote.ConsolidatedWeatherRemoteDataSource
import com.hugo.fairecast.domain.repository.ConsolidatedWeatherRepository
import org.koin.core.qualifier.TypeQualifier
import org.koin.dsl.module

private val consolidatedWeatherRepositoryModules = module {
    single {
        ConsolidatedWeatherRepository(
            get(
                qualifier = TypeQualifier(
                    ConsolidatedWeatherRemoteDataSource::class
                )
            )
        )
    }
}

val repositoryModules = arrayOf(consolidatedWeatherRepositoryModules)