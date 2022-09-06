package com.geekbrains.dictionary

import android.app.Application
import android.content.Context
import android.util.Log
import com.geekbrains.dictionary.di.Di
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(Di.mainModule)
        }
        instance = this


    }

    fun setContext(context: Context) {
        mainContext = context
    }

    fun getContext() : Context{
        return instance
    }

    companion object {
        lateinit var mainContext: Context
        lateinit var instance: App
            private set
    }

}