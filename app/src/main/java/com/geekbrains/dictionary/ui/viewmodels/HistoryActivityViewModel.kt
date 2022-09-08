package com.geekbrains.dictionary.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import com.geekbrains.dictionary.data.OnCallbackWebRequest
import com.geekbrains.dictionary.datasource.RetrofitWebConnection
import com.geekbrains.dictionary.domain.skyeng.SkyengBase
import com.geekbrains.dictionary.ui.HistoryActivityContract
import com.geekbrains.dictionary.ui.MainActivityContract
import timber.log.Timber

class HistoryActivityViewModel : HistoryActivityContract.ViewModel() {
     val shouldShowProgress = MutableLiveData<Boolean>()
     val skyengBaseLiveData = MutableLiveData<List<SkyengBase>>()


    override fun loadData() {
        TODO("Not yet implemented")
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