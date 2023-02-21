package com.drozdova.danceevents.domain.repository

import com.drozdova.danceevents.presentation.model.EventModel

interface EventsRepo {
    fun getEventsList() : List<EventModel>
    fun getFavEventsList() : List<EventModel>
    fun getEventsInMonth(date: String) : List<EventModel>
    fun searchEvents(title: String) : List<EventModel>
}