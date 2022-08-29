package com.hugo.fairecast.modules

import com.hugo.fairecast.data.services.ForecastService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private val retrofit = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://cdn.faire.com/static/mobile-take-home/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single {
        get<Retrofit>().create(ForecastService::class.java)
    }
}

val serviceModules = listOf(retrofit)