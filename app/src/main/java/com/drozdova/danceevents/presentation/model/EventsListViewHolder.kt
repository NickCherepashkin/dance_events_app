package com.drozdova.danceevents.presentation.model

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.drozdova.danceevents.databinding.ItemEventVerBinding
import com.drozdova.danceevents.presentation.model.model.EventModel

class EventsListViewHolder(
    private val view: ItemEventVerBinding,
    private val eventListener: EventListener
) : ViewHolder(view.root) {

    fun bind(event: EventModel) {
        view.eventTitle.text = event.title
        view.eventDateStart.text = event.dateStart
        view.eventDateEnd.text = event.dateEnd

        itemView.setOnClickListener {
            eventListener.showDetails()
        }
    }
}