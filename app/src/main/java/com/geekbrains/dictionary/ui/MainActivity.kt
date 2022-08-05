package com.geekbrains.dictionary.ui

import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.geekbrains.dictionary.R
import com.geekbrains.dictionary.databinding.ActivityMainBinding
import com.geekbrains.dictionary.domain.skyeng.SkyengBase
import com.geekbrains.dictionary.ui.viewmodels.MainActivityViewModel
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val myAdapter by lazy { MainActivityAdapter() }
    private val progressDialog by lazy { ProgressDialog(this) }

    private val scope = CoroutineScope(Dispatchers.Main)
    private val scope2 = CoroutineScope(Dispatchers.IO)
    private var job: Job? = null
    private var job2: Job? = null

    private val viewModel: MainActivityContract.ViewModel by lazy {
        ViewModelProvider(this)[MainActivityViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setTheme(R.style.MyThemeOrange)
        setContentView(binding.root)
        initRecyclerView()


        binding.inputLayout.setEndIconOnClickListener {
            viewModel.requestTranslated(binding.inputTextEt.text.toString())
        }

        job2 = scope2.async(start = CoroutineStart.LAZY) {
            delay(2000)
            (0..10).random().toString()
        }

        binding.buttonKoin.setOnClickListener {
            job?.cancel()
            job = scope.launch {
                showProgressDialog("Job2 test  " + (job2 as Deferred<String>)?.await())
                delay(5000)
                dismissProgressDialog()
            }
        }

        viewModel.shouldShowProgress.observe(this) {
            if (it) showProgressDialog("Load data") else dismissProgressDialog()
        }

        viewModel.skyengBaseLiveData.observe(this) { list ->
            showListWordsTranslated(list)
        }
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = myAdapter
    }

    private fun showListWordsTranslated(list: List<SkyengBase>) {
        myAdapter.refreshList(list)
    }

    private fun showProgressDialog(s: String) {
        progressDialog.setTitle(s)
        progressDialog.setMessage("... please wait")
        progressDialog.show()
    }

    private fun dismissProgressDialog() {
        progressDialog.dismiss()
    }

}