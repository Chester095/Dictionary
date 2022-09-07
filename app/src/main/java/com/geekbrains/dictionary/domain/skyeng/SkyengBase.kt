package com.geekbrains.dictionary.domain.skyeng

import com.google.gson.annotations.SerializedName

data class SkyengBase (

	@SerializedName("id") val id : Int,
	@SerializedName("text") val text : String,
	@SerializedName("imageUrl") val imageUrl : String,
	@SerializedName("meanings") val meanings : List<Meanings>
)