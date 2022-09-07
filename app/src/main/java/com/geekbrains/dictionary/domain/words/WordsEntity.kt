package com.geekbrains.dictionary.domain.words

data class WordsEntity(
    val translationText:String? = null,
    val imageUrl:String? = null,
    val transcription: String?  = null
)
