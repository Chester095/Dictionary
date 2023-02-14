package com.geekbrains.dictionary.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.geekbrains.dictionary.data.dao.HistoryDAO
import com.geekbrains.dictionary.data.entities.HistoryEntity

@Database(entities = [HistoryEntity::class], version = 1, exportSchema = true)
abstract class HistoryDB: RoomDatabase(){
    abstract fun historyDao():HistoryDAO
}
