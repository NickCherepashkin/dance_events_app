package com.drozdova.danceevents.presentation.view.favorites

import android.net.Uri
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.drozdova.danceevents.databinding.ItemEventHorBinding
import com.drozdova.danceevents.presentation.view.listener.EventListener
import com.drozdova.danceevents.presentation.model.EventModel
import com.drozdova.danceevents.presentation.view.listener.FavListener
import com.squareup.picasso.Picasso

class FavEventsHolder(
    private val view: ItemEventHorBinding,
    private val favListener: FavListener
) : ViewHolder(view.root) {

    fun bind(event: EventModel) {
        view.eventTitle.text = event.title
        view.eventDateStart.text = "${event.dateStart} - ${event.dateEnd}"
        Picasso.get().load(Uri.parse(event.photo)).into(view.imvEventHor)

        itemView.setOnClickListener {
            favListener.showDetails(event)
        }

        view.imvFavDelete.setOnClickListener {
            favListener.deleteFav(event.id)
        }
    }
}