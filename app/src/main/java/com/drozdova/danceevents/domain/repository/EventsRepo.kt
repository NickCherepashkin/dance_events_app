package com.drozdova.danceevents.domain.repository

import com.drozdova.danceevents.presentation.model.EventModel

interface EventsRepo {
    suspend fun getEventsList()
    suspend fun showEventsList() : List<EventModel>
    suspend fun getFavEventsList()
    suspend fun showFavEvents() : List<EventModel>
    suspend fun favClicked(id_event: Int, isFavorite: Boolean)
    suspend fun favDelete(idUser: Int, idEvent: Int)

    suspend fun getEventsInMonth(date: String) : List<EventModel>
    suspend fun searchEvents(title: String) : List<EventModel>
}