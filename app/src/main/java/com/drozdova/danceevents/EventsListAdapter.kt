package com.drozdova.danceevents

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.drozdova.danceevents.databinding.ItemEventVerBinding

class EventsListAdapter : RecyclerView.Adapter<EventsListViewHolder>() {
    private var _binding: ItemEventVerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventsListViewHolder {
        _binding = ItemEventVerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EventsListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EventsListViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}   