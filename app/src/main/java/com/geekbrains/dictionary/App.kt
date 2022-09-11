package com.geekbrains.dictionary

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.geekbrains.dictionary.data.HistoryDatabase
import com.geekbrains.dictionary.di.Di
import org.koin.core.context.startKoin
import timber.log.Timber

class App : Application() {

    private var db: HistoryDatabase? = null

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        startKoin {
            modules(Di.mainModule)
        }
        instance = this
        db = Room.databaseBuilder(this,  HistoryDatabase::class.java, "history_database")
            .build()
    }

    fun getInstance(): App {
        return instance
    }

    fun getDatabase(): HistoryDatabase? {
        return db
    }
    fun setContext(context: Context) {
        mainContext = context
    }

    fun getContext() : Context {
        return mainContext
    }

    companion object {
        lateinit var mainContext: Context
        lateinit var instance: App
            private set
    }

}