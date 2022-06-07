package com.geekbrains.dictionary.data

import com.geekbrains.dictionary.domain.skyeng.SkyengBase

interface OnCallbackWebRequest {
    fun onResponse(body: List<SkyengBase>?)
    fun onFailure()
}