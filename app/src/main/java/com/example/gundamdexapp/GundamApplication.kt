package com.example.gundamdexapp

import android.app.Application
import com.example.gundamdexapp.data.network.AppContainer

class GundamApplication : Application() {
    lateinit var appContainer: AppContainer

    override fun onCreate() {
        super.onCreate()
        appContainer = AppContainer()
    }
}
