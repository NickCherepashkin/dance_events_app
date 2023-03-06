package com.drozdova.danceevents.presentation.view.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.drozdova.danceevents.databinding.ItemEventHorBinding
import com.drozdova.danceevents.presentation.view.listener.EventListener
import com.drozdova.danceevents.presentation.model.EventModel
import com.drozdova.danceevents.presentation.view.listener.SearchListener

class SearchAdapter(
    private val searchListener: SearchListener
) : RecyclerView.Adapter<SearchViewHolder>() {
    private var _binding: ItemEventHorBinding? = null
    private val binding get() = _binding!!

    private var listSearchEvents = mutableListOf<EventModel>()

    fun submit(listSearchEvents: List<EventModel>) {
        this.listSearchEvents.clear()
        this.listSearchEvents.addAll(listSearchEvents.toMutableList())
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        _binding = ItemEventHorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(binding, searchListener)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(listSearchEvents[position])
    }

    override fun getItemCount(): Int {
        return listSearchEvents.size
    }
}