package com.geekbrains.dictionary.di

import com.geekbrains.dictionary.ui.MainActivityPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, StorageModule::class])
interface AppComponent {
    fun injectMainActivityPresenter(mainActivityPresenter: MainActivityPresenter)




}