package com.geekbrains.dictionary.ui

interface HistoryActivityContract {

    abstract class ViewModel : androidx.lifecycle.ViewModel() {
        abstract fun loadData()
    }

}