package com.geekbrains.dictionary.presenter

import android.app.Activity

interface MainPresenter {
    fun attachPresenter(activity: Activity)
    fun getListFromDB()
}