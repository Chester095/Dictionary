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


class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val myAdapter by lazy { MainActivityAdapter() }
    private val progressDialog by lazy { ProgressDialog(this) }


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

        viewModel.shouldShowProgress.observe(this) {
            if (it) showProgressDialog() else dismissProgressDialog()
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

    private fun showProgressDialog() {
        progressDialog.setTitle("Load data")
        progressDialog.setMessage("... please wait")
        progressDialog.show()
    }

    private fun dismissProgressDialog() {
        progressDialog.dismiss()
    }

}