package com.drozdova.danceevents

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.Calendar

class MonthAdapter : RecyclerView.Adapter<MonthViewHolder>() {

    private var listOfMonths = listOf<String>()
    private var listOfYears = listOf<Int>()
    private lateinit var adapter: DateAdapter

    fun submit(listOfMonths: List<String>,) {
        this.listOfMonths = listOfMonths
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonthViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.month_item, parent, false)
        return MonthViewHolder(view)
    }

    override fun onBindViewHolder(holder: MonthViewHolder, position: Int) {

        val pos = position + 1
        val days = when(position) {
            1 -> 28
            0, 2, 4, 6, 7, 9, 11 -> 31
            else -> 30
        }

        val calendar = Calendar.getInstance()
        calendar.set(2023, position,0)
        val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
        val spaces = dayOfWeek - 1

        holder.bind(listOfMonths[position], days,pos, 2023, spaces)
    }

    override fun getItemCount(): Int {
        return listOfMonths.size
    }
}