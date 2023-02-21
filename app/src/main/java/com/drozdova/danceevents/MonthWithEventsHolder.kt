package com.drozdova.danceevents

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.drozdova.danceevents.databinding.ItemEventHorBinding
import com.drozdova.danceevents.model.EventModel

class MonthWithEventsHolder(
    private val view: ItemEventHorBinding,
    private val eventListener: EventListener
): ViewHolder(view.root){
    fun bind(event: EventModel) {
        view.eventTitle.text = event.title
        view.eventDateStart.text = "${event.dateStart} - ${event.dateEnd}"

        itemView.setOnClickListener {
            eventListener.showDetails()
        }
    }
}