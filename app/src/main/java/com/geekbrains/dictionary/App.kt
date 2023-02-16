package com.geekbrains.dictionary

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.room.Room
import com.geekbrains.dictionary.data.HistoryDB
import com.geekbrains.dictionary.data.dao.HistoryDAO
import com.geekbrains.dictionary.di.Di
import org.koin.core.context.GlobalContext.startKoin
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        // инициализация appInstance
        appInstance = this



        Timber.plant(Timber.DebugTree())
        startKoin {
            modules(Di.mainModule)
        }
/*        db = Room.databaseBuilder(this,  HistoryDatabase::class.java, "history_database")
            .build()
        Timber.d("db = $db")*/
    }

    companion object {
        private const val TAG = "App"
        private var appInstance: App? = null

        // сама БД
        private var db: HistoryDB? = null

        // название нашей БД
        private const val DB_NAME = "History.db"


        // инициализация БД
        fun getHistoryDao(): HistoryDAO {
            if (db == null) {
                Timber.tag(TAG).d("History.db  db != null")
                synchronized(HistoryDB::class.java) {
                    if (db == null) {
                        appInstance?.let { app ->
                            db = Room.databaseBuilder(
                                app.applicationContext,
                                HistoryDB::class.java,
                                DB_NAME
                            ).build()
                        } ?: throw Exception("Что-то пошло не так")
                    }
                }
            }
            return db!!.historyDao()
        }

        lateinit var mainContext: Context
            private set
    }
/*
    fun getDatabase(): HistoryDB? {
        return db
    }*/

    fun setContext(context: Context) {
        mainContext = context
    }

    fun getContext() : Context {
        return mainContext
    }

}