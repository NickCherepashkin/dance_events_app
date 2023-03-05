package com.drozdova.danceevents.domain.repository

import com.drozdova.danceevents.presentation.model.EventModel

interface EventsRepo {
    suspend fun getEventsList()
    suspend fun showEventsList() : List<EventModel>
    suspend fun getFavEventsList()
    suspend fun showFavEvents() : List<EventModel>

    suspend fun getEventsInMonth(date: String) : List<EventModel>
    suspend fun searchEvents(title: String) : List<EventModel>
}