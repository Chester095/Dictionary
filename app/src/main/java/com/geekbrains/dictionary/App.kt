package com.geekbrains.dictionary

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.geekbrains.dictionary.data.HistoryDB
import com.geekbrains.dictionary.data.dao.HistoryDao
import com.geekbrains.dictionary.di.Di
import org.koin.core.context.startKoin
import timber.log.Timber

class App : Application() {

    private var db: HistoryDB? = null

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        startKoin {
            modules(Di.mainModule)
        }
        // инициализация appInstance
        appInstance = this

/*      db = Room.databaseBuilder(this, HistoryDatabase::class.java, "history_database")
            .build()        */
    }

    companion object {
        private var appInstance: App? = null

        // сама БД
        private var db: HistoryDB? = null

        // название нашей БД
        private const val DB_NAME = "History.db"

        // инициализация БД
        fun getHistoryDao(): HistoryDao {
            if (db == null) {
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
    }

    fun setContext(context: Context) {
        mainContext = context
    }

    fun getContext(): Context {
        return mainContext
    }

}