package com.geekbrains.dictionary.presenter

import android.app.Activity
import com.geekbrains.dictionary.data.BaseDataBase
import com.geekbrains.dictionary.view.MainActivity

class MainPresenterImpl(private val dataBase: BaseDataBase) :MainPresenter {
    private lateinit var mainActivity: MainActivity
    override fun attachPresenter(activity: Activity) {
        mainActivity = activity as MainActivity
    }

    override fun getListFromDB() {
        val list = dataBase.returnBase()
        mainActivity.setListForView(list)
    }
}