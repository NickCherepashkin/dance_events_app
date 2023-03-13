package com.drozdova.danceevents.presentation.view.search

import android.annotation.SuppressLint
import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.drozdova.danceevents.R
import com.drozdova.danceevents.databinding.ItemEventHorBinding
import com.drozdova.danceevents.presentation.model.EventModel
import com.drozdova.danceevents.presentation.view.listener.SearchListener
import com.squareup.picasso.Picasso

class SearchViewHolder(
    private val view: ItemEventHorBinding,
    private val searchListener: SearchListener
) : ViewHolder(view.root){

    @SuppressLint("SetTextI18n")
    fun bind(event: EventModel) {
        view.eventTitle.text = event.title
        view.eventDateStart.text = "${event.dateStart} - ${event.dateEnd}"
        Picasso.get().load(Uri.parse(event.photo)).placeholder(R.drawable.default_img).into(view.imvEventHor)

        view.imvFavDelete.visibility = View.GONE

        itemView.setOnClickListener {
            searchListener.showDetails(event)
        }
    }
}