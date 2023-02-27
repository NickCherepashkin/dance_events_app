package com.drozdova.danceevents.presentation.view.calendar

import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.drozdova.danceevents.databinding.DateItemBinding
import com.drozdova.danceevents.presentation.view.listener.MonthListener

class DateViewHolder(
    private val view: DateItemBinding,
    private val monthListener: MonthListener
) : ViewHolder(view.root) {

    fun bind(year: Int, month: Int, spaces: Int, pos: Int) {
        val value: Int
        if(pos == spaces){
            value = 1
            view.tvDate.text = "$value"
        } else if (pos > spaces) {
            value = 1 + (pos - spaces)
            view.tvDate.text = "$value"
        } else {
            view.tvDate.text = ""
        }

        if (pos % 7 == 5 || pos % 7 == 6) {
            view.tvDate.setTextColor(Color.RED)
        }
        itemView.setOnClickListener {
            monthListener.showMonthWithEvents(year, month)
        }
    }
}