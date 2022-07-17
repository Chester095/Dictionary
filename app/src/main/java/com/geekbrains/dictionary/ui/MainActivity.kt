package com.geekbrains.dictionary.ui

import android.app.ProgressDialog
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.utils.ViewState
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.geekbrains.dictionary.R
import com.geekbrains.dictionary.databinding.ActivityMainBinding
import com.geekbrains.dictionary.domain.words.WordsEntity
import com.geekbrains.dictionary.ui.viewmodels.MainActivityViewModel


class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val myAdapter by lazy { MainActivityAdapter() }
    private val progressDialog by lazy { ProgressDialog(this) }

    private val viewModel: MainActivityContract.ViewModel by lazy {
        ViewModelProvider(this)[MainActivityViewModel::class.java]
    }
    private val handler: Handler by lazy { Handler(Looper.getMainLooper()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setTheme(R.style.MyThemeOrange)
        setContentView(binding.root)
        initRecyclerView()

        binding.inputLayout.setEndIconOnClickListener {
            viewModel.requestTranslated(binding.inputTextEt.text.toString())
        }

        viewModel.shouldShowProgress.observe(this) {
            if (it) showProgressDialog() else dismissProgressDialog()
        }

        viewModel.skyengBaseLiveData.observe(this) { list ->
            val data = list.map{
                WordsEntity(it.meanings.firstOrNull()?.translation?.text)
                // доделать БигНёрдРач
            }
            showListWordsTranslated(data)
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

    override fun onDestroy() {
//        presenter.detachView()
        super.onDestroy()

    }

}