package com.hugo.fairecast

import com.hugo.fairecast.data.services.ForecastService
import com.hugo.fairecast.modules.serviceModules
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*
import org.koin.core.context.startKoin
import org.koin.test.KoinTest
import org.koin.test.inject

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ForecastServiceTest : KoinTest{

    private val service: ForecastService by inject()

    @Test
    fun forecastServiceReturnIsValid() = runBlocking {
        startKoin {
            modules(
                *serviceModules
            )
        }

        val response = service.listRepos(4418) // Toronto Id
        assertEquals(response.isSuccessful, true)
    }
}