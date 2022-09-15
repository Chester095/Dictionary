package com.geekbrains.dictionary.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.geekbrains.dictionary.App
import com.geekbrains.dictionary.R
import com.geekbrains.dictionary.data.HistoryDatabase

class HistoryActivityAdapter : RecyclerView.Adapter<HistoryActivityAdapter.HistoryActivityViewHolder>() {
    private var db: HistoryDatabase? = App.instance.getDatabase()
    private val historyDao by lazy { db?.historyDao() }
/*
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
    }*/

    override fun getItemCount(): Int = historyDao?.getRowCount()!!

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryActivityViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_history, parent, false)
        return HistoryActivityViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HistoryActivityViewHolder, position: Int) {
        if (historyDao!=null) {
            holder.translation.text = historyDao?.getId(position).toString()
        }
    }

    class HistoryActivityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val translation: TextView = itemView.findViewById(R.id.item_text_view)
    }
}
