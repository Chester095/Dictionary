package com.geekbrains.dictionary.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.geekbrains.dictionary.R
import com.geekbrains.dictionary.domain.skyeng.SkyengBase
import com.geekbrains.dictionary.domain.words.WordsEntity

class MainActivityAdapter:RecyclerView.Adapter<MainActivityAdapter.MainActivityViewHolder>() {
    private var listWords = listOf<WordsEntity>()

    @SuppressLint("NotifyDataSetChanged")
    fun refreshList(list: List<SkyengBase>){
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
                        it.transcription
                    )
                )
            }
        }
        return wordsRepoImpl
    }

    override fun getItemCount(): Int = listWords.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainActivityViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_translate,parent,false)
        return MainActivityViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MainActivityViewHolder, position: Int) {
        if(listWords.isNotEmpty()) {
        holder.translation.text = listWords[position].translationText
        }

    }

    class MainActivityViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val translation:TextView = itemView.findViewById(R.id.item_text_view)
    }
}