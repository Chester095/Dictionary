package com.geekbrains.dictionary.data

import com.geekbrains.dictionary.data.dao.HistoryDAO
import com.geekbrains.dictionary.data.entities.HistoryEntity

class LocalRepositoryImpl(private val dao: HistoryDAO) : LocalRepository {

    override fun getAllHistory(): List<HistoryEntity> {
        return dao.getAll()
            .map { entity ->
                HistoryEntity(
                    id = entity.id,
                    historyName = entity.historyName
                )

            }
    }

    override fun saveEntity(historyEntity: HistoryEntity) {
        dao.insertHistory(
            HistoryEntity(
                id = 0,
                historyName = historyEntity.historyName
            )

        )
    }
}