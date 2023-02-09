package com.drozdova.danceevents

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.google.android.material.textview.MaterialTextView

class CalendarViewHolder(
    private val calendarView: View
) : ViewHolder(calendarView) {
    fun bind( year: Int) {
        val rvYear = calendarView.findViewById<RecyclerView>(R.id.rv_year)
        val tvYear = calendarView.findViewById<MaterialTextView>(R.id.tv_year)

        tvYear.text = year.toString()

        rvYear.setHasFixedSize(true)
        rvYear.isNestedScrollingEnabled = true
        val monthAdapter = MonthAdapter()
        rvYear.adapter = monthAdapter
        val listOfMonths = calendarView.resources.getStringArray(R.array.month_array).toList()
        monthAdapter.submit(listOfMonths)
    }
}