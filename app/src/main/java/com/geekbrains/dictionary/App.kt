package com.geekbrains.dictionary

import android.app.Application
import com.geekbrains.dictionary.data.BaseDataBase
import com.geekbrains.dictionary.data.BaseDataBaseImpl
import com.geekbrains.dictionary.presenter.MainPresenter
import com.geekbrains.dictionary.presenter.MainPresenterImpl

class App:Application() {
    lateinit var dataBase: BaseDataBase
    lateinit var mainPresenter: MainPresenter

    override fun onCreate() {
        super.onCreate()
        instance = this
        //Инициализируем наши компоненты
        dataBase = BaseDataBaseImpl()
        mainPresenter = MainPresenterImpl(dataBase)
    }

    companion object {
        lateinit var instance: App
            private set
    }

}