package com.geekbrains.dictionary.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.geekbrains.dictionary.App
import com.geekbrains.dictionary.R
import com.geekbrains.dictionary.data.LocalRepositoryImpl
import com.geekbrains.dictionary.databinding.ActivityHistoryBinding
import timber.log.Timber

class HistoryActivity : AppCompatActivity() {


    private var _binding: ActivityHistoryBinding? = null
    private val binding get() = _binding!!


    /*    private val myAdapter by lazy { HistoryActivityAdapter() }

        private val viewModel: HistoryActivityContract.ViewModel by lazy {
            ViewModelProvider(this)[HistoryActivityViewModel::class.java]
        }*/
/*    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Timber.d("starting initRecyclerView()")
        initRecyclerView()
    }*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.tag("!!! HistoryActivity").d(" onCreate")
        _binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
/*        val actionBar = supportActionBar
        actionBar!!.title = "История запросов"*/
        Timber.tag("!!! HistoryActivity").d(" setContentView")


        findViewById<RecyclerView>(R.id.recycler_view).apply {
//            Timber.tag("!!! HistoryActivity").d(" findViewById")
            // получаем данные из нашей БД
            Thread {
                adapter =
                    HistoryActivityAdapter(LocalRepositoryImpl(App.getHistoryDao()).getAllHistory()).also {
                        it.notifyDataSetChanged()
                    }
            }.start()

        }
        Timber.tag("!!! HistoryActivity").d(" adapter")
    }
/*
    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = myAdapter
    }*/

}
