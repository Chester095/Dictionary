package com.geekbrains.dictionary.data

import com.geekbrains.dictionary.domain.words.WordsEntity
import com.geekbrains.dictionary.domain.words.WordsEntityUseCase
import io.reactivex.rxjava3.core.Single


class WordsRepoImpl : WordsEntityUseCase {
    private var cashWords = mutableListOf<WordsEntity>()

    override fun createWord(word: WordsEntity) {
        cashWords.add(word)
    }

    override fun clearRepo() {
        cashWords.clear()
    }

    override fun getListWordsFromRepo(): List<WordsEntity> {
        return cashWords
    }

    override val dataList: Single<List<WordsEntity>>
        get() = Single.just(cashWords)

}