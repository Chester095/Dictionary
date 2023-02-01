package com.geekbrains.dictionary.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.geekbrains.dictionary.App
import com.geekbrains.dictionary.R
import com.geekbrains.dictionary.data.HistoryDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.*

class HistoryActivityAdapter(private var items: List<Dictionary>) : RecyclerView.Adapter<HistoryActivityAdapter.HistoryActivityViewHolder>() {
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

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryActivityViewHolder {
        return HistoryActivityViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_history, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: HistoryActivityViewHolder, position: Int) {
        val history = items[position]

        holder.itemView.apply {
            findViewById<TextView>(R.id.item_text_view).text = history.
//            holder.historyName.text = historyDao?.getId(position).toString()
        }
    }

    class HistoryActivityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val historyName: TextView = itemView.findViewById(R.id.item_text_view)
    }
}
