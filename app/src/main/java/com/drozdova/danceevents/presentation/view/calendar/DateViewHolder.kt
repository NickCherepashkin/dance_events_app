package com.drozdova.danceevents.presentation.view.calendar

import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.drozdova.danceevents.R
import com.drozdova.danceevents.databinding.DateItemBinding
import com.drozdova.danceevents.presentation.view.listener.MonthListener

class DateViewHolder(
    private val view: DateItemBinding,
    private val monthListener: MonthListener
) : ViewHolder(view.root) {

    fun bind(year: Int, month: Int, spaces: Int, pos: Int) {

        val value = fillingInDays(spaces, pos)
        view.tvDate.text = value

        if (value.isNotEmpty()) {
            selectWeekendDays(pos)
            checkEventDay(value.toInt(), month, year, pos)}

        itemView.setOnClickListener {
            monthListener.showMonthWithEvents(year, month)
        }
    }

    private fun fillingInDays(spaces: Int, pos: Int) : String {
        return if(pos == spaces){
            FIRST_DAY_IN_MONTH
        } else if (pos > spaces) {
            "${(1 + (pos - spaces))}"
        } else {
            EMPTY_SPACE_IN_MONTH
        }
    }

    private fun selectWeekendDays(pos: Int) {
        if (pos % DAYS_IN_WEEK == POS_SATURDAY || pos % DAYS_IN_WEEK == POS_SUNDAY) {
            view.tvDate.setTextColor(Color.RED)
        }
    }

    fun checkEventDay(day: Int, month: Int, year: Int, pos: Int) {
        if (monthListener.selectDate(day, month, year)) {
            view.dayLayout.setBackgroundResource(R.drawable.day_event_selected)
            if (pos % DAYS_IN_WEEK < POS_SATURDAY) {
                view.tvDate.setTextColor(Color.BLACK)
            }
        }
    }

    companion object {
        const val DAYS_IN_WEEK = 7
        const val POS_SATURDAY = 5
        const val POS_SUNDAY = 6

        const val EMPTY_SPACE_IN_MONTH = ""
        const val FIRST_DAY_IN_MONTH = "1"
    }
}