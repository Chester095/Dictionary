package com.geekbrains.dictionary.ui

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.geekbrains.dictionary.App
import com.geekbrains.dictionary.R
import com.geekbrains.dictionary.domain.skyeng.SkyengBase
import com.geekbrains.dictionary.domain.words.WordsEntity

class MainActivityAdapter : RecyclerView.Adapter<MainActivityAdapter.MainActivityViewHolder>() {
    private var listWords = listOf<WordsEntity>()

    @SuppressLint("NotifyDataSetChanged")
    fun refreshList(list: List<SkyengBase>) {
        this.listWords = convertForRepository(list)
        notifyDataSetChanged()
    }


    private fun convertForRepository(listSkyEng: List<SkyengBase>): List<WordsEntity> {
        val wordsRepoImpl = mutableListOf<WordsEntity>()
        listSkyEng.forEach { it ->
            it.meanings.forEach {
                wordsRepoImpl.add(
                    WordsEntity(
                        it.translation.text,
                        it.imageUrl,
                        it.transcription
                    )
                )
            }
        }
        return wordsRepoImpl
    }

    override fun getItemCount(): Int = listWords.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainActivityViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_translate, parent, false)
        return MainActivityViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MainActivityViewHolder, position: Int) {
        if (listWords.isNotEmpty()) {
            holder.translation.text = listWords[position].translationText

            var requestOptions = RequestOptions()
            requestOptions = requestOptions.transforms(FitCenter(), RoundedCorners(16))
            Glide.with(holder.itemView.context)
                .load("https:" + listWords[position].imageUrl)
                .apply(requestOptions)
                .skipMemoryCache(true)
                .into(holder.imageUrl)
        }
    }

    class MainActivityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val translation: TextView = itemView.findViewById(R.id.item_text_view)
        val imageUrl: ImageView = itemView.findViewById<View>(R.id.item_imageUrl) as ImageView
    }
}
