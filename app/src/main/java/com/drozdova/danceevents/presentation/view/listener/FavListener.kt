package com.drozdova.danceevents.presentation.view.listener

import com.drozdova.danceevents.presentation.model.EventModel

interface FavListener {
    fun showDetails(event: EventModel)
    fun deleteFav(idEvent: Int)
}