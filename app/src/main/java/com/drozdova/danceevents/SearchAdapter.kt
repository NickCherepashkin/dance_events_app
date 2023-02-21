package com.drozdova.danceevents

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.drozdova.danceevents.databinding.ItemEventHorBinding
import com.drozdova.danceevents.model.EventModel

class SearchAdapter(
    private val eventListener: EventListener
) : RecyclerView.Adapter<SearchViewHolder>() {
    private var _binding: ItemEventHorBinding? = null
    private val binding get() = _binding!!

    private var listSearchEvents = listOf<EventModel>()

    fun submit(listSearchEvents: List<EventModel>) {
        this.listSearchEvents = listSearchEvents
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        _binding = ItemEventHorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(binding, eventListener)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(listSearchEvents[position])
    }

    override fun getItemCount(): Int {
        return listSearchEvents.size
    }
}