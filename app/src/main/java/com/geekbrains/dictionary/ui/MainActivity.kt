package com.geekbrains.dictionary.ui

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.utils.ViewState
import androidx.recyclerview.widget.LinearLayoutManager
import com.geekbrains.dictionary.R
import com.geekbrains.dictionary.databinding.ActivityMainBinding
import com.geekbrains.dictionary.domain.words.WordsEntity


class MainActivity : AppCompatActivity(), MainActivityContract.ViewModel{

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val myAdapter by lazy { MainActivityAdapter() }
    private val progressDialog by lazy { ProgressDialog(this) }
//    private var presenter: MainActivityContract.MainActivityPresenter = MainActivityPresenter(this)
    private val VIEW_STATE_KEY = "VIEW_STATE_KEY"
    private var viewState: ViewState = ViewState.INIT
    private var viewModel: MainActivityContract.ViewModel?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setTheme(R.style.MyThemeOrange)
        setContentView(binding.root)
//        presenter.attachView(this)
viewModel?.loadDataFromRepo().sub
        initRecyclerView()

        binding.inputLayout.setEndIconOnClickListener {
            presenter.requestTranslated(binding.inputTextEt.text.toString())
        }
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = myAdapter
    }

    fun showListWordsTranslated(list: List<WordsEntity>) {
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