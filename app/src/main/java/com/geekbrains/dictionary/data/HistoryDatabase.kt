package com.geekbrains.dictionary.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.geekbrains.dictionary.data.dao.HistoryDao
import com.geekbrains.dictionary.data.entities.History

@Database(entities = [History::class], version = 1, exportSchema = true)
abstract class HistoryDatabase : RoomDatabase() {
    abstract fun historyDao(): HistoryDao
}