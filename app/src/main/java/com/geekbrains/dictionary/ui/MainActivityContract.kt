package com.geekbrains.dictionary.ui

import com.geekbrains.dictionary.utils.Publisher

class MainActivityContract {

    interface ViewModel{
        val shouldShowProgress: Publisher<Boolean>

        fun requestTranslated(searchWord: String)
        fun loadDataFromRepo()
    }

}