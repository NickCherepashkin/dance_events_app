package com.drozdova.danceevents

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.drozdova.danceevents.databinding.YearItemBinding

class CalendarViewHolder(
    private val view: YearItemBinding
) : ViewHolder(view.root) {

    fun bind(year: Int) {
        view.tvYear.text = year.toString()

        view.rvYear.setHasFixedSize(true)
        view.rvYear.isNestedScrollingEnabled = true
        val monthAdapter = MonthAdapter()
        view.rvYear.adapter = monthAdapter
        val listOfMonths = view.root.resources.getStringArray(R.array.month_array).toList()
        monthAdapter.submit(year, listOfMonths)
    }
}