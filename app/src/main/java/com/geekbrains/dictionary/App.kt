package com.geekbrains.dictionary

import android.app.Application
import com.geekbrains.dictionary.di.DaggerAppComponent

class App:Application() {
    var appComponent =  DaggerAppComponent.create()

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: App
            private set
    }

}