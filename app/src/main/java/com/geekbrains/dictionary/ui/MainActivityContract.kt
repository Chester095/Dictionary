package com.geekbrains.dictionary.ui

import androidx.lifecycle.LiveData
import com.geekbrains.dictionary.domain.skyeng.SkyengBase

interface MainActivityContract {

    abstract class ViewModel : androidx.lifecycle.ViewModel() {
        abstract val shouldShowProgress: LiveData<Boolean>
        abstract val skyengBaseLiveData: LiveData<List<SkyengBase>>

        abstract fun requestTranslated(searchWord: String)
    }

}