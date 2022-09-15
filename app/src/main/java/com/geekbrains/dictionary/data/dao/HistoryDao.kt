package com.geekbrains.dictionary.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.geekbrains.dictionary.data.entities.History

@Dao
interface HistoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertHistory(history: History)

    @Query("SELECT * FROM history_table")
    fun getAll(): List<History>

    @Query("SELECT * FROM history_table WHERE id =:id")
    fun getId(id: Int?) : LiveData<History>

    @Query("SELECT * FROM history_table WHERE id =:id")
    fun getHistory(id: Int?) : LiveData<History>


    @Query("SELECT COUNT(id) FROM history_table")
    fun getRowCountLiveData(): LiveData<Int?>

    @Query("SELECT COUNT(id) FROM history_table")
    fun getRowCount(): Int

}