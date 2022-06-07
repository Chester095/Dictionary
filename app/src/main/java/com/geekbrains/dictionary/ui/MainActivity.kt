package com.geekbrains.dictionary.ui

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.geekbrains.dictionary.databinding.ActivityMainBinding
import com.geekbrains.dictionary.domain.words.WordsEntity


class MainActivity : AppCompatActivity(), MainActivityContract.MainActivityView{

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val myAdapter by lazy { MainActivityAdapter() }
    private val progressDialog by lazy { ProgressDialog(this) }
    private var presenter: MainActivityContract.MainActivityPresenter = MainActivityPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter.attachView(this)

        initRecyclerView()

        binding.searchButton.setOnClickListener {
            val text = binding.inputTextEt.text
            presenter.requestTranslated(binding.inputTextEt.text.toString())
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = myAdapter
    }

    override fun showListWordsTranslated(list: List<WordsEntity>) {
        myAdapter.refreshList(list)
        Log.d("!!!", "showListTranslated: ")
    }

    fun showProgressDialog() {
        progressDialog.setTitle("Load data")
        progressDialog.setMessage("... please wait")
        progressDialog.show()
    }

    fun dismissProgressDialog() {
        progressDialog.dismiss()
    }


    override fun showError() {

    }

    override fun startShowProgressLoading() {
        showProgressDialog()
    }

    override fun stopShowProgressLoading() {
        dismissProgressDialog()
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()

    }

}