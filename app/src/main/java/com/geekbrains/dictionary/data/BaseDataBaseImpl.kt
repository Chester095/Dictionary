package com.geekbrains.dictionary.data

class BaseDataBaseImpl:BaseDataBase {
    private val db = listOf(
        "one",
        "two",
        "three"
    )

    override fun returnBase(): List<String> {
        return db
    }
}