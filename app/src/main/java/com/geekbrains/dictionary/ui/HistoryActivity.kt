package com.geekbrains.dictionary.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.geekbrains.dictionary.databinding.ActivityHistoryBinding
import com.geekbrains.dictionary.ui.viewmodels.HistoryActivityViewModel
import timber.log.Timber


class HistoryActivity : AppCompatActivity() {

    private var _binding: ActivityHistoryBinding? = null
    private val binding get() = _binding!!

    private val myAdapter by lazy { HistoryActivityAdapter() }

    private val viewModel: HistoryActivityContract.ViewModel by lazy {
        ViewModelProvider(this)[HistoryActivityViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        Timber.tag("!!!").d("layoutManager")
        Timber.tag("!!!").d("adapter")


        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = myAdapter
    }

}
