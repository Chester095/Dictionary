package com.geekbrains.dictionary.di

import com.geekbrains.dictionary.ui.MainProgressDialog
import org.koin.dsl.module

object Di {

    // тут создаём все зависимости, которые нам нужны
    val mainModule = module{
        single { MainProgressDialog() }
    }

}