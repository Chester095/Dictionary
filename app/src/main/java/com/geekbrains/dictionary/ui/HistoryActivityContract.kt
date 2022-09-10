package com.geekbrains.dictionary.ui

import com.geekbrains.dictionary.data.OnCallbackWebRequest

interface HistoryActivityContract {

    abstract class ViewModel : androidx.lifecycle.ViewModel() {
        abstract fun loadData()
        abstract val onCallbackWebRequest: OnCallbackWebRequest
        abstract fun addData(history: String)
    }

}