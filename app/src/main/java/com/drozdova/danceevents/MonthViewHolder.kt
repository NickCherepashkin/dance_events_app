package com.drozdova.danceevents

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.drozdova.danceevents.databinding.MonthItemBinding

class MonthViewHolder (
    private val view: MonthItemBinding
) : ViewHolder(view.root) {

    fun bind(month: String, days: Int, year: Int, spaces: Int) {
        view.tvMonth.text = month
        view.rvDate.setHasFixedSize(true)
        view.rvDate.isNestedScrollingEnabled = true
        val dateAdapter = DateAdapter()
        view.rvDate.adapter = dateAdapter
        dateAdapter.submit(days, year, spaces)
    }
}