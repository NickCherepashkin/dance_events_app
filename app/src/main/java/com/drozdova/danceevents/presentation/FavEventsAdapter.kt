package com.drozdova.danceevents.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.drozdova.danceevents.databinding.ItemEventHorBinding
import com.drozdova.danceevents.presentation.model.EventModel

class FavEventsAdapter(
    private val eventListener: EventListener
) : RecyclerView.Adapter<FavEventsHolder>() {
    private var _binding: ItemEventHorBinding? = null
    private val binding get() = _binding!!

    private var listFavEvents = listOf<EventModel>()

    fun submit(listFavEvents: List<EventModel>) {
        this.listFavEvents = listFavEvents
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavEventsHolder {
        _binding = ItemEventHorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavEventsHolder(binding, eventListener)
    }

    override fun onBindViewHolder(holder: FavEventsHolder, position: Int) {
        holder.bind(listFavEvents[position])
    }

    override fun getItemCount(): Int {
        return listFavEvents.size
    }
}