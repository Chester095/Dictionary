package com.geekbrains.dictionary.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.geekbrains.dictionary.data.entities.HistoryEntity

@Dao
interface HistoryDAO {
    // получить все данные из БД
    // "ORDER BY id DESC" - отсортировать по полю id в обратном порядке
    @Query("SELECT * FROM history_table ORDER BY id DESC")
    fun getAll(): List<HistoryEntity>

    @Query("SELECT * FROM history_table WHERE id =:id")
    fun getId(id: Int?) : LiveData<HistoryEntity>

    // добавить данные
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertHistory(historyEntity: HistoryEntity)

    @Query("SELECT * FROM history_table WHERE id =:id")
    fun getHistory(id: Int?) : LiveData<HistoryEntity>


    @Query("SELECT COUNT(id) FROM history_table")
    fun getRowCountLiveData(): LiveData<Int?>

    @Query("SELECT COUNT(id) FROM history_table")
    fun getRowCount(): Int

}