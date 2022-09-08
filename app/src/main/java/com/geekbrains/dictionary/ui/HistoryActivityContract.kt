package com.geekbrains.dictionary.ui

import androidx.lifecycle.LiveData
import com.geekbrains.dictionary.data.OnCallbackWebRequest
import com.geekbrains.dictionary.domain.skyeng.SkyengBase

interface HistoryActivityContract {

    abstract class ViewModel : androidx.lifecycle.ViewModel() {
        abstract fun loadData()
        abstract val onCallbackWebRequest: OnCallbackWebRequest
    }

}