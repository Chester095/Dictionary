package com.geekbrains.dictionary.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.geekbrains.dictionary.App
import com.geekbrains.dictionary.databinding.ActivityHistoryBinding


class HistoryActivity : AppCompatActivity() {

    private var _binding: ActivityHistoryBinding? = null
    private val binding get() = _binding!!

//    private val myAdapter by lazy { HistoryActivityAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.historyRecyclerView.apply {
            // получаем данные из нашей БД
            Thread {
                adapter = HistoryActivityAdapter(LocalRepositoryImpl(App.getHistoryDao()).getAllHistory()).also {
                    it.notifyDataSetChanged()
                }
            }.start()
        }
    }

}
