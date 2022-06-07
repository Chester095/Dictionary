package com.geekbrains.dictionary.domain.words

import io.reactivex.rxjava3.core.Single

interface WordsEntityUseCase {
    fun createWord(word: WordsEntity)
    fun clearRepo()
    fun getListWordsFromRepo(): List<WordsEntity>
    val dataList: Single<List<WordsEntity>>
}