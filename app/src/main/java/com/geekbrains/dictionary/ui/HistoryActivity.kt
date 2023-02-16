package com.geekbrains.dictionary.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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

        _binding = ActivityHistoryBinding.inflate(layoutInflater)
        setTheme(R.style.MyThemeOrange)
        setContentView(binding.root)
        val actionBar = supportActionBar
        actionBar!!.title = "История запросов"

        Timber.tag("!!! HistoryActivity").d(" onCreate")
        Timber.tag("!!! HistoryActivity").d(" setContentView")

        binding.recyclerView.apply {
            Timber.tag("!!! HistoryActivity").d(" apply")
            // получаем данные из нашей БД
            Thread {
                adapter =
                    HistoryActivityAdapter(LocalRepositoryImpl(App.getHistoryDao()).getAllHistory()).also {
                        it.notifyDataSetChanged()
                    }
            }.start()
        }
        Timber.tag("!!! HistoryActivity").d(" start")

    }
/*
    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = myAdapter
    }*/

}
