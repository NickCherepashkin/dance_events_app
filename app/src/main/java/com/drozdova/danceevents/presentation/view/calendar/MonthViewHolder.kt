package com.drozdova.danceevents.presentation.view.calendar

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.drozdova.danceevents.databinding.MonthItemBinding
import com.drozdova.danceevents.presentation.view.listener.MonthListener

class MonthViewHolder (
    private val view: MonthItemBinding,
    private val monthListener: MonthListener
) : ViewHolder(view.root) {

    fun bind(year: Int, month: String, monthNumber: Int, days: Int, spaces: Int) {
        view.tvMonth.text = month
        view.rvDate.setHasFixedSize(true)
        view.rvDate.isNestedScrollingEnabled = true
        val dateAdapter = DateAdapter(monthListener)
        view.rvDate.adapter = dateAdapter
        dateAdapter.submit(year, monthNumber, days, spaces)
    }
}