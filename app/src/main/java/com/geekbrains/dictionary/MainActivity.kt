package com.geekbrains.dictionary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.geekbrains.dictionary.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.MyThemeOrange)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

}