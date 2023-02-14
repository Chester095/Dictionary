package com.geekbrains.dictionary.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import com.geekbrains.dictionary.ui.HistoryActivityContract
import kotlinx.coroutines.*

class HistoryActivityViewModel : HistoryActivityContract.ViewModel() {
    override val shouldShowProgress = MutableLiveData<Boolean>()
    private val scopeHistory = CoroutineScope(Dispatchers.IO)
    private var jobHistory: Job? = null


    override fun loadData() {
        shouldShowProgress.postValue(true)
    }

}