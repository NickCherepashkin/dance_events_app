package com.drozdova.danceevents.presentation.view.calendar

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.drozdova.danceevents.R
import com.drozdova.danceevents.databinding.YearItemBinding
import com.drozdova.danceevents.presentation.view.listener.MonthListener

class CalendarViewHolder(
    private val view: YearItemBinding,
    private val monthListener: MonthListener
) : ViewHolder(view.root) {

    fun bind(year: Int) {
        view.tvYear.text = year.toString()

        view.rvYear.setHasFixedSize(true)
        view.rvYear.isNestedScrollingEnabled = true
        val monthAdapter = MonthAdapter(monthListener)
        view.rvYear.adapter = monthAdapter
        val listOfMonths = view.root.resources.getStringArray(R.array.month_array).toList()
        monthAdapter.submit(year, listOfMonths)
    }
}