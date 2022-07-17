package com.geekbrains.dictionary.di

import com.geekbrains.dictionary.data.WordsRepoImpl
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