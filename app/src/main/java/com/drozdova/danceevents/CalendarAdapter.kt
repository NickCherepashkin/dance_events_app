package com.drozdova.danceevents

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.drozdova.danceevents.databinding.YearItemBinding

class CalendarAdapter : RecyclerView.Adapter<CalendarViewHolder>() {
    private var _binding: YearItemBinding? = null
    private val binding get() =_binding!!

    private var listOfYears = listOf<Int>()

    fun submit(listOfYears: List<Int>) {
        this.listOfYears = listOfYears
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder {
        _binding = YearItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CalendarViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {
        holder.bind(listOfYears[position])
    }

    override fun getItemCount(): Int {
        return listOfYears.size
    }
}