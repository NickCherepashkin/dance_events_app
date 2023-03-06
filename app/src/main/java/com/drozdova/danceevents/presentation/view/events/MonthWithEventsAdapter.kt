package com.drozdova.danceevents.presentation.view.events

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.drozdova.danceevents.databinding.ItemEventHorBinding
import com.drozdova.danceevents.presentation.view.listener.EventListener
import com.drozdova.danceevents.presentation.model.EventModel
import com.drozdova.danceevents.presentation.view.listener.MonthWithEventsListener

class MonthWithEventsAdapter(
    private val listener: MonthWithEventsListener
) : RecyclerView.Adapter<MonthWithEventsHolder>() {
    private var _binding: ItemEventHorBinding? = null
    private val binding get() = _binding!!

    private var eventsInMonthList = mutableListOf<EventModel>()

    fun submit(eventsInMonthList: List<EventModel>) {
        this.eventsInMonthList.clear()
        this.eventsInMonthList.addAll(eventsInMonthList.toMutableList())
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonthWithEventsHolder {
        _binding = ItemEventHorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MonthWithEventsHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: MonthWithEventsHolder, position: Int) {
        holder.bind(eventsInMonthList[position])
    }

    override fun getItemCount(): Int {
        return eventsInMonthList.size
    }
}