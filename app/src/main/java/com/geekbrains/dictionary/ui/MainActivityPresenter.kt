package com.geekbrains.dictionary.ui

import android.util.Log
import com.geekbrains.dictionary.App
import com.geekbrains.dictionary.data.OnCallbackWebRequest
import com.geekbrains.dictionary.data.WordsRepoImpl
import com.geekbrains.dictionary.datasource.RetrofitWebConnection
import com.geekbrains.dictionary.domain.skyeng.SkyengBase
import com.geekbrains.dictionary.domain.words.WordsEntity
import javax.inject.Inject

private const val TAG = "!!!"

class MainActivityPresenter(private val mainActivity: MainActivity) :
    MainActivityContract.MainActivityPresenter {

    private var view: MainActivityContract.MainActivityView? = null


    @Inject lateinit var wordsRepoImpl: WordsRepoImpl

    init {
        App.instance.appComponent.injectMainActivityPresenter(this)
    }

    override fun attachView(view: MainActivityContract.MainActivityView) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }

    override fun requestTranslated(searchWord: String) {
        loadDataFromWeb(searchWord)
        mainActivity.showProgressDialog()
    }

    private fun loadDataFromWeb(searchWord: String) {
        RetrofitWebConnection(onCallbackWebRequest).webRequest(searchWord)
    }

    private val onCallbackWebRequest = object : OnCallbackWebRequest {
        override fun onResponse(body: List<SkyengBase>?) {
            if (body != null) {convertForRepository(body)
            Log.d(TAG, "onCallbackWebRequest  " + body.toString())}
            Log.d(TAG, "onCallbackWebRequest  " + body.toString())
        }

        override fun onFailure() {
            Log.d(TAG,"Что-то пошло не так")
        }
    }

    override fun loadDataFromRepo() {

        val list = wordsRepoImpl.getListWordsFromRepo()
        Log.d(TAG, "loadDataFromRepo  " + list.toString())
        mainActivity.showListWordsTranslated(list)
        mainActivity.dismissProgressDialog()
    }

    private fun convertForRepository(listSkyEng: List<SkyengBase>) {
        Log.d(TAG, "convertForRepository  " + listSkyEng.toString())
        wordsRepoImpl.clearRepo()
        listSkyEng.forEach { it ->
            it.meanings.forEach {
                wordsRepoImpl.createWord(
                    word = WordsEntity(
                        it.translation.text,
                        it.transcription
                    )
                )
            }
        }

        loadDataFromRepo()
    }


}