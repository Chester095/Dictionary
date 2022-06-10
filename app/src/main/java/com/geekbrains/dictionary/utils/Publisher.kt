package com.geekbrains.dictionary.utils

import android.os.Handler

data class Publisher<T>(
    private val handler: Handler,
    private val callback: (T?) -> Unit
){
    fun invoke(value: T?) {
        handler.post {
            callback.invoke(value)
        }
    }
}
