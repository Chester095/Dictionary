package com.geekbrains.dictionary.ui

import com.geekbrains.dictionary.domain.words.WordsEntity

class MainActivityContract {

    interface MainActivityView{
        fun showListWordsTranslated(list:List<WordsEntity>)
        fun showError()
        fun startShowProgressLoading()
        fun stopShowProgressLoading()

    }

    interface MainActivityPresenter{
        fun attachView(view: MainActivityView)
        fun detachView()
        fun requestTranslated(searchWord: String)
        fun loadDataFromRepo()
    }

}