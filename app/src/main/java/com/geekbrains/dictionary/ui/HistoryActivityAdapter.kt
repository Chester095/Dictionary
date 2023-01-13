package com.geekbrains.dictionary.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.geekbrains.dictionary.App
import com.geekbrains.dictionary.R
import com.geekbrains.dictionary.data.HistoryDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class HistoryActivityAdapter : RecyclerView.Adapter<HistoryActivityAdapter.HistoryActivityViewHolder>() {
    private var db: HistoryDatabase? = App.appInstance.getDatabase()
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
        Timber.tag("!!!").d("onCreateViewHolder itemView%s", itemView)
        return HistoryActivityViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HistoryActivityViewHolder, position: Int) {
        Timber.tag("!!!").d("onBindViewHolder")
        if (historyDao!=null) {
            Timber.tag("!!!").d("onBindViewHolder")
            CoroutineScope(Dispatchers.IO).launch{
                holder.historyName.text = historyDao?.getId(position).toString()
            }
            Timber.tag("!!!").d("onBindViewHolder position = position%s ", position)
//            holder.translation.text = historyDao?.getId(position).toString()
        }
    }

    class HistoryActivityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val historyName: TextView = itemView.findViewById(R.id.item_text_view)
    }
}
