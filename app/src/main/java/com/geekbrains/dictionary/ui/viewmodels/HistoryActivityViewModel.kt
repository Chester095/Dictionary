package com.geekbrains.dictionary.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import com.geekbrains.dictionary.App
import com.geekbrains.dictionary.data.OnCallbackWebRequest
import com.geekbrains.dictionary.data.entities.History
import com.geekbrains.dictionary.domain.skyeng.SkyengBase
import com.geekbrains.dictionary.ui.HistoryActivityContract
import kotlinx.coroutines.*
import timber.log.Timber

class HistoryActivityViewModel : HistoryActivityContract.ViewModel() {
     val shouldShowProgress = MutableLiveData<Boolean>()
     val skyengBaseLiveData = MutableLiveData<List<SkyengBase>>()
    private val scopeHistory = CoroutineScope(Dispatchers.IO)
    private var jobHistory: Job? = null


    override fun loadData() {
        TODO("Not yet implemented")
    }

}