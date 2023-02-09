package com.drozdova.danceevents

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class DateAdapter : RecyclerView.Adapter<DateViewHolder>() {

    private var days: Int = 0
    private var year: Int = 0
    private var spaces: Int = 0

    fun submit(days: Int, pos: Int, Y: Int, spaces: Int) {
        this.days = days
        year = Y
        this.spaces = spaces
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.date_item, parent, false)
        return DateViewHolder(view)
    }

    override fun onBindViewHolder(holder: DateViewHolder, position: Int) {
        holder.bind(days, position, year, spaces)
    }

    override fun getItemCount(): Int {
        return days + spaces
    }
}