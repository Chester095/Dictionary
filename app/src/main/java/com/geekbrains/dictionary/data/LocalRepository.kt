package com.geekbrains.dictionary.data

import com.geekbrains.dictionary.data.entities.HistoryEntity

interface LocalRepository {
    fun getAllHistory() : List<HistoryEntity>

    fun saveEntity(historyEntity: HistoryEntity)
}