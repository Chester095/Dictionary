package com.geekbrains.dictionary.ui

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.geekbrains.dictionary.App
import com.geekbrains.dictionary.R
import com.geekbrains.dictionary.data.LocalRepositoryImpl
import com.geekbrains.dictionary.data.entities.HistoryEntity
import com.geekbrains.dictionary.databinding.ActivityMainBinding
import com.geekbrains.dictionary.domain.skyeng.SkyengBase
import com.geekbrains.dictionary.ui.viewmodels.MainActivityViewModel
import kotlinx.coroutines.*
import org.koin.android.ext.android.inject


class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val myAdapter by lazy { MainActivityAdapter() }
    private val progressDialog by lazy { ProgressDialog(this) }

    private val scope = CoroutineScope(Dispatchers.Main)
    private val scope2 = CoroutineScope(Dispatchers.IO)
    private val scope3 = CoroutineScope(Dispatchers.IO)
    private var job: Job? = null
    private var job2: Job? = null
    private var job3: Job? = null
/*
    var db: HistoryDB? = App.appInstance!!.getDatabase()
    private val historyDao = db?.historyDao()*/

    private val mainProgressDialog: MainProgressDialog by inject()

    private val viewModel: MainActivityContract.ViewModel by lazy {
        ViewModelProvider(this)[MainActivityViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setTheme(R.style.MyThemeOrange)
        setContentView(binding.root)
        initRecyclerView()
        App().setContext(this)
        val actionBar = supportActionBar
        actionBar!!.title = "Словарь"


        binding.inputLayout.setEndIconOnClickListener {
            initRecyclerView()
            addData(binding.inputTextEt.text.toString())
            viewModel.requestTranslated(binding.inputTextEt.text.toString())

        }

        binding.buttonHistory.setOnClickListener {
            val intent = Intent(this@MainActivity, HistoryActivity::class.java)
            startActivity(intent)
        }

        job2 = scope2.async(start = CoroutineStart.LAZY) {
            delay(2000)
            (0..10).random().toString()
        }

        binding.buttonKoin.setOnClickListener {
            job?.cancel()
            job = scope.launch {
                showProgressDialog("Job2 test  " + (job2 as Deferred<String>).await())
                delay(5000)
                dismissProgressDialog()
            }
        }

        viewModel.shouldShowProgress.observe(this) {
            initRecyclerView()
            if (it) mainProgressDialog.showProgressDialog()
            else mainProgressDialog.dismissProgressDialog()
        }

        viewModel.skyengBaseLiveData.observe(this) { list ->
            showListWordsTranslated(list)
        }
    }

    private fun addData(historyName: String) {

        job3?.cancel()
        job3 = scope3.launch {
            val historyEntityTemp = HistoryEntity(0, historyName)
            LocalRepositoryImpl(App.getHistoryDao()).saveEntity(historyEntityTemp)
        }
/*        CoroutineScope(Dispatchers.IO).launch {
            val historyEntityTemp = HistoryEntity(0, historyName)
            LocalRepositoryImpl(App.getHistoryDao()).saveEntity(historyEntityTemp)
        }*/
    }

    private fun initRecyclerView() {
        binding.recyclerView.adapter = myAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
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
