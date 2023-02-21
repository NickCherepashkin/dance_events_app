package com.drozdova.danceevents.presentation.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.drozdova.danceevents.databinding.ItemEventHorBinding
import com.drozdova.danceevents.presentation.model.model.EventModel

class MonthWithEventsAdapter(
    private val eventListener: EventListener
) : RecyclerView.Adapter<MonthWithEventsHolder>() {
    private var _binding: ItemEventHorBinding? = null
    private val binding get() = _binding!!

    private var eventsInMonthList = listOf<EventModel>()

    fun submit(eventsInMonthList: List<EventModel>) {
        this.eventsInMonthList = eventsInMonthList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonthWithEventsHolder {
        _binding = ItemEventHorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MonthWithEventsHolder(binding, eventListener)
    }

    override fun onBindViewHolder(holder: MonthWithEventsHolder, position: Int) {
        holder.bind(eventsInMonthList[position])
    }

    override fun getItemCount(): Int {
        return eventsInMonthList.size
    }
}