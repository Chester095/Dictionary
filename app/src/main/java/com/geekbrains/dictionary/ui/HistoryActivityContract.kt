package com.geekbrains.dictionary.ui

import androidx.lifecycle.LiveData

interface HistoryActivityContract {

    abstract class ViewModel : androidx.lifecycle.ViewModel() {
        abstract val shouldShowProgress: LiveData<Boolean>
        abstract fun loadData()
    }

}