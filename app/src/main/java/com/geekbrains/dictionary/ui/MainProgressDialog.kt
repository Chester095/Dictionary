package com.geekbrains.dictionary.ui

import android.app.ProgressDialog
import com.geekbrains.dictionary.App

class MainProgressDialog {

    private val progressDialog by lazy { ProgressDialog(App().getContext()) }

    fun showProgressDialog() {
        progressDialog.setTitle("Load data")
        progressDialog.setMessage("... please wait")
        progressDialog.show()
    }

    fun dismissProgressDialog() {
        progressDialog.dismiss()
    }
}