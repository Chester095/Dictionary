package com.geekbrains.dictionary.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.geekbrains.dictionary.R
import com.geekbrains.dictionary.data.entities.HistoryEntity
import timber.log.Timber

class HistoryActivityAdapter(private var items: List<HistoryEntity>) : RecyclerView.Adapter<HistoryActivityAdapter.HistoryItemViewHolder>() {

/*    private var db: HistoryDB? = App.appInstance.getDatabase()
    private val historyDao by lazy { db?.historyDao() }*/

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryItemViewHolder {
        Timber.d("starting onCreateViewHolder")
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_history, parent, false)
        return HistoryItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HistoryItemViewHolder, position: Int) {
        Timber.d("starting onBindViewHolder")
        val dictionary = items[position]

        holder.itemView.apply {
            findViewById<TextView>(R.id.item_text_view).text = dictionary.historyName
        }

    }

    override fun getItemCount(): Int = items.size

    class HistoryItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val translation: TextView = itemView.findViewById(R.id.item_text_view)
    }
}
