package com.drozdova.danceevents

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CalendarAdapter : RecyclerView.Adapter<CalendarViewHolder>() {
    private var listOfYears = listOf<Int>()

    fun submit(listOfYears: List<Int>) {
        this.listOfYears = listOfYears
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.year_item, parent, false)
        return CalendarViewHolder(view)
    }

    override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {
        holder.bind(listOfYears[position])
    }

    override fun getItemCount(): Int {
        return 2
    }
}