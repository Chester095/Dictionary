package com.geekbrains.dictionary

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.geekbrains.dictionary.data.HistoryDatabase
import com.geekbrains.dictionary.data.dao.HistoryDao
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

        appInstance = this
/*
        Timber.d("db1 = $db")
        db = Room.databaseBuilder(this, HistoryDatabase::class.java, "history_database")
            .build()
        Timber.d("db2 = $db")*/
    }

    companion object {
        private var appInstance: App? = null
        private var db: HistoryDatabase? = null
        private const val DB_NAME = "history_database"

        fun getHistoryDao(): HistoryDao {
            if (db == null) {
                synchronized(HistoryDatabase::class.java) {
                    if (db == null) {
                        appInstance?.let { app ->
                            db = Room.databaseBuilder(
                                app.applicationContext,
                                HistoryDatabase::class.java,
                                DB_NAME
                            ).build()
                        } ?: throw Exception("Что-то пошлого не так")
                    }
                }
            }
            return db!!.historyDao()
        }

        lateinit var mainContext: Context
    }

    fun getDatabase(): HistoryDatabase? {
        return db
    }

    fun setContext(context: Context) {
        mainContext = context
    }

    fun getContext(): Context {
        return mainContext
    }

}