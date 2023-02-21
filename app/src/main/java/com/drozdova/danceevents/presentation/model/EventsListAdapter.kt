package com.drozdova.danceevents.presentation.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.drozdova.danceevents.databinding.ItemEventVerBinding
import com.drozdova.danceevents.presentation.model.model.EventModel

class EventsListAdapter(
    private val eventListener: EventListener
) : RecyclerView.Adapter<EventsListViewHolder>() {
    private var _binding: ItemEventVerBinding? = null
    private val binding get() = _binding!!

    private var listOfEvents = listOf<EventModel>()

    fun submit(listOfEvents: List<EventModel>) {
        this.listOfEvents = listOfEvents
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventsListViewHolder {
        _binding = ItemEventVerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EventsListViewHolder(binding, eventListener)
    }

    override fun onBindViewHolder(holder: EventsListViewHolder, position: Int) {
        holder.bind(listOfEvents[position])
    }

    override fun getItemCount(): Int {
        return listOfEvents.size
    }
}   