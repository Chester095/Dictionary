package com.geekbrains.dictionary.ui

import android.app.ProgressDialog
import android.content.Context
import com.geekbrains.dictionary.App

class MainProgressDialog (private val context: Context) {

    private val progressDialog by lazy { ProgressDialog(context) }

    fun showProgressDialog() {
        progressDialog.setTitle("Load data")
        progressDialog.setMessage("... please wait")
        progressDialog.show()
    }

    fun dismissProgressDialog() {
        progressDialog.dismiss()
    }
}