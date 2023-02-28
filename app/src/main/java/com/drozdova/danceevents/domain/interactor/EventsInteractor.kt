package com.drozdova.danceevents.domain.interactor

import com.drozdova.danceevents.domain.repository.EventsRepo
import com.drozdova.danceevents.presentation.model.EventModel
import javax.inject.Inject

class EventsInteractor @Inject constructor(
    private val eventsListRepo: EventsRepo
) {
    suspend fun getEventsList() : List<EventModel> {
        return eventsListRepo.getEventsList()
    }

    suspend fun getFavEventsList() : List<EventModel> {
        return eventsListRepo.getFavEventsList()
    }

    suspend fun getEventsInMonth(date: String) : List<EventModel> {
        return eventsListRepo.getEventsInMonth(date)
    }

    suspend fun searchEvents(title: String) : List<EventModel> {
        return eventsListRepo.searchEvents(title)
    }
}