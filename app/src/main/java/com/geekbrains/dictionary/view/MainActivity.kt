package com.geekbrains.dictionary.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.geekbrains.dictionary.App
import com.geekbrains.dictionary.R
import com.geekbrains.dictionary.databinding.ActivityMainBinding
import com.geekbrains.dictionary.presenter.MainPresenterImpl
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BaseView{
    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: MainPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.MyThemeOrange)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = App.instance.mainPresenter as MainPresenterImpl
        presenter.attachPresenter(this)
        button.setOnClickListener {
            presenter.getListFromDB()
        }
    }

    override fun setListForView(list: List<String>) {
        var string = ""
        list.forEach {
            string += it
        }
        text_view.text = string
    }

}