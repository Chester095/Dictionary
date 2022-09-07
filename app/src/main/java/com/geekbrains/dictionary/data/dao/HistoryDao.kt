package com.geekbrains.dictionary.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.geekbrains.dictionary.data.entities.History

@Dao
interface HistoryDao {
    @Query("SELECT * FROM history_table")
    fun getAll(): List<History>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertHistory(string: List<History>)
}