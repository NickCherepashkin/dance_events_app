package com.drozdova.danceevents.presentation.view.calendar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.drozdova.danceevents.databinding.YearItemBinding
import com.drozdova.danceevents.presentation.view.listener.MonthListener

class CalendarAdapter(
    private val monthListener: MonthListener
) : RecyclerView.Adapter<CalendarViewHolder>() {
    private var _binding: YearItemBinding? = null
    private val binding get() =_binding!!

    private var listOfYears = listOf<Int>()

    fun submit(listOfYears: List<Int>) {
        this.listOfYears = listOfYears
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder {
        _binding = YearItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CalendarViewHolder(binding, monthListener)
    }

    override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {
        holder.bind(listOfYears[position])
    }

    override fun getItemCount(): Int {
        return listOfYears.size
    }
}