package com.drozdova.danceevents.domain.repository

import com.drozdova.danceevents.presentation.model.EventModel

interface EventsRepo {
    suspend fun getEventsList() : List<EventModel>
    suspend fun getFavEventsList() : List<EventModel>
    suspend fun getEventsInMonth(date: String) : List<EventModel>
    suspend fun searchEvents(title: String) : List<EventModel>
}