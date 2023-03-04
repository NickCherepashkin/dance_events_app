package com.drozdova.danceevents.presentation.view.events

import android.net.Uri
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.drozdova.danceevents.databinding.ItemEventVerBinding
import com.drozdova.danceevents.presentation.view.listener.EventListener
import com.drozdova.danceevents.presentation.model.EventModel
import com.squareup.picasso.Picasso

class EventsListViewHolder(
    private val view: ItemEventVerBinding,
    private val eventListener: EventListener
) : ViewHolder(view.root) {

    fun bind(event: EventModel) {
        view.eventTitle.text = event.title
        view.eventDateStart.text = event.dateStart
        view.eventDateEnd.text = event.dateEnd
        Picasso.get().load(Uri.parse(event.photo)).into(view.imvEventVer)

        itemView.setOnClickListener {
            eventListener.showDetails(event)
        }
    }
}