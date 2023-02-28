package com.geekbrains.dictionary.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.geekbrains.dictionary.App
import com.geekbrains.dictionary.R
import com.geekbrains.dictionary.data.LocalRepositoryImpl
import com.geekbrains.dictionary.databinding.ActivityHistoryBinding
import timber.log.Timber

class HistoryActivity : AppCompatActivity() {

    private var _binding: ActivityHistoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityHistoryBinding.inflate(layoutInflater)
        setTheme(R.style.MyThemeOrange)
        setContentView(binding.root)
        supportActionBar!!.title = "История запросов"

        binding.recyclerView.apply {
            binding.recyclerView.layoutManager = LinearLayoutManager(context)
            Thread {
                adapter =
                    HistoryActivityAdapter(LocalRepositoryImpl(App.getHistoryDao()).getAllHistory()).also {
                        it.notifyDataSetChanged()
                    }
            }.start()
        }
    }

}
