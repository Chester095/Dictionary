package com.geekbrains.dictionary.ui

import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.geekbrains.dictionary.R
import com.geekbrains.dictionary.databinding.ActivityHistoryBinding
import com.geekbrains.dictionary.ui.viewmodels.MainActivityViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import org.koin.android.ext.android.inject


class HistoryActivity : AppCompatActivity() {

    private var _binding: ActivityHistoryBinding? = null
    private val binding get() = _binding!!

    private val myAdapter by lazy { HistoryActivityAdapter() }
    private val progressDialog by lazy { ProgressDialog(this) }

    private val scope = CoroutineScope(Dispatchers.Main)
    private val scope2 = CoroutineScope(Dispatchers.IO)
    private var job2: Job? = null

    private val mainProgressDialog: MainProgressDialog by inject()

    private val viewModel: MainActivityContract.ViewModel by lazy {
        ViewModelProvider(this)[MainActivityViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHistoryBinding.inflate(layoutInflater)
        setTheme(R.style.MyThemeOrange)
        setContentView(binding.root)

/*        viewModel.shouldShowProgress.observe(this) {
            initRecyclerView()
            if (it) mainProgressDialog.showProgressDialog()
            else mainProgressDialog.dismissProgressDialog()
        }

        viewModel.skyengBaseLiveData.observe(this) { list ->
            showListWordsTranslated(list)
        }*/
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = myAdapter
    }


}
