package com.geekbrains.dictionary.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import com.geekbrains.dictionary.data.OnCallbackWebRequest
import com.geekbrains.dictionary.data.entities.History
import com.geekbrains.dictionary.datasource.RetrofitWebConnection
import com.geekbrains.dictionary.domain.skyeng.SkyengBase
import com.geekbrains.dictionary.ui.HistoryActivityContract
import com.geekbrains.dictionary.ui.MainActivityContract
import timber.log.Timber

class MainActivityViewModel : MainActivityContract.ViewModel() {
    override val shouldShowProgress = MutableLiveData<Boolean>()
    override val skyengBaseLiveData = MutableLiveData<List<SkyengBase>>()

    override fun requestTranslated(searchWord: String) {
        loadDataFromWeb(searchWord)
    }

    override fun loadDataFromWeb(searchWord: String) {
        shouldShowProgress.postValue(true)
        RetrofitWebConnection(onCallbackWebRequest).webRequest(searchWord)
    }

    override val onCallbackWebRequest = object : OnCallbackWebRequest {
        override fun onResponse(body: List<SkyengBase>?) {
            body?.let { response -> skyengBaseLiveData.postValue(response) }
            shouldShowProgress.postValue(false)
        }

        override fun onFailure() {
            shouldShowProgress.postValue(false)
            Timber.d("Что-то пошло не так")
        }
    }


}