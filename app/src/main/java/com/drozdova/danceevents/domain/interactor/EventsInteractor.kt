package com.drozdova.danceevents.domain.interactor

import com.drozdova.danceevents.domain.repository.EventsRepo
import com.drozdova.danceevents.presentation.model.EventModel
import javax.inject.Inject

class EventsInteractor @Inject constructor(
    private val eventsListRepo: EventsRepo
) {
    suspend fun getEventsList()  {
        eventsListRepo.getEventsList()
    }

    suspend fun showEventsList() : List<EventModel> {
        return eventsListRepo.showEventsList()
    }

    suspend fun getFavEventsList() {
        eventsListRepo.getFavEventsList()
    }

    suspend fun showFavEventsList() : List<EventModel> {
        return eventsListRepo.showFavEvents()
    }

    suspend fun getEventsInMonth(date: String) : List<EventModel> {
        return eventsListRepo.getEventsInMonth(date)
    }

    suspend fun searchEvents(title: String) : List<EventModel> {
        return eventsListRepo.searchEvents(title)
    }
}