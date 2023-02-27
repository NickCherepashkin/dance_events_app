package com.drozdova.danceevents.presentation.view.favorites

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.drozdova.danceevents.databinding.ItemEventHorBinding
import com.drozdova.danceevents.presentation.view.listener.EventListener
import com.drozdova.danceevents.presentation.model.EventModel

class FavEventsHolder(
    private val view: ItemEventHorBinding,
    private val eventListener: EventListener
) : ViewHolder(view.root) {

    fun bind(event: EventModel) {
        view.eventTitle.text = event.title
        view.eventDateStart.text = "${event.dateStart} - ${event.dateEnd}"

        itemView.setOnClickListener {
            eventListener.showDetails(event)
        }
    }
}