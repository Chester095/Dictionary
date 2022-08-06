package com.geekbrains.dictionary.ui.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.geekbrains.dictionary.data.OnCallbackWebRequest
import com.geekbrains.dictionary.datasource.RetrofitWebConnection
import com.geekbrains.dictionary.domain.skyeng.SkyengBase
import com.geekbrains.dictionary.ui.MainActivityContract

private const val TAG = "!!!"

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
            Log.d(TAG,"Что-то пошло не так")
        }
    }

}