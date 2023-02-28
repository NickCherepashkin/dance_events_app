package com.drozdova.danceevents.presentation.view.events

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.drozdova.danceevents.databinding.ItemEventVerBinding
import com.drozdova.danceevents.presentation.view.listener.EventListener
import com.drozdova.danceevents.presentation.model.EventModel

class EventsListAdapter(
    private val eventListener: EventListener
) : RecyclerView.Adapter<EventsListViewHolder>() {
    private var _binding: ItemEventVerBinding? = null
    private val binding get() = _binding!!

    private var listOfEvents = mutableListOf<EventModel>()

    fun submit(listOfEvents: List<EventModel>) {
        this.listOfEvents.clear()
        this.listOfEvents.addAll(listOfEvents.toMutableList())
        this.notifyDataSetChanged()
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