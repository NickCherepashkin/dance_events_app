package com.drozdova.danceevents.presentation

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.drozdova.danceevents.databinding.DateItemBinding

class DateViewHolder(
    private val view: DateItemBinding,
    private val monthListener: MonthListener
) : ViewHolder(view.root) {

    fun bind(days: Int, pos: Int, year: Int, spaces: Int) {
        val value: Int
        if(pos == spaces){
            value = 1
            view.tvDate.text = "${value}"
        } else if (pos > spaces) {
            value = 1 + (pos - spaces)
            view.tvDate.text = "${value}"
        } else {
            view.tvDate.text = ""
        }

        itemView.setOnClickListener {
            monthListener.showMonthWithEvents()
        }
    }
}