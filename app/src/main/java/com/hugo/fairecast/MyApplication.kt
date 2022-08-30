package com.hugo.fairecast

import android.app.Application
import com.hugo.fairecast.modules.dataSourceModules
import com.hugo.fairecast.modules.repositoryModules
import com.hugo.fairecast.modules.serviceModules
import com.hugo.fairecast.modules.viewModelModules
import org.koin.core.context.GlobalContext.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            printLogger()
            modules(*serviceModules, *viewModelModules, *dataSourceModules, *repositoryModules)
        }
    }
}