package com.geekbrains.dictionary.ui

import com.geekbrains.dictionary.domain.words.WordsEntity

class MainActivityContract {

    interface ViewModel{
        fun requestTranslated(searchWord: String)
        fun loadDataFromRepo()
    }

}