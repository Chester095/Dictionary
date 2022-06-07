package com.geekbrains.dictionary.di

import com.geekbrains.dictionary.data.WordsRepoImpl
import com.geekbrains.dictionary.ui.MainActivityPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StorageModule {
    @Singleton
    @Provides
    fun provideWordsRepoImpl(): WordsRepoImpl {
        return WordsRepoImpl()
    }
}