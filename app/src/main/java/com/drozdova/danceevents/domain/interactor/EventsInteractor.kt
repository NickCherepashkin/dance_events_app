package com.drozdova.danceevents.domain.interactor

import android.util.Log
import com.drozdova.danceevents.domain.repository.EventsRepo
import com.drozdova.danceevents.presentation.model.EventDateModel
import com.drozdova.danceevents.presentation.model.EventModel
import com.drozdova.danceevents.utils.ResultCodes
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EventsInteractor @Inject constructor(
    private val eventsListRepo: EventsRepo
) {
    suspend fun getEventsList() : Int {
        var result = eventsListRepo.getEventsList()
        if (result == ResultCodes.RESULT_SUCCESS) {
            result = eventsListRepo.getFavEventsList()
        }
        Log.w("resultCore", "$result")
        return result
    }

    suspend fun showEventsList() : List<EventModel> {
        return eventsListRepo.showEventsList()
    }

    suspend fun getFavEventsList() : Int {
        return eventsListRepo.getFavEventsList()
    }

    suspend fun showFavEventsList() : Flow<List<EventModel>> {
        return eventsListRepo.showFavEvents()
    }

    suspend fun getEventsInMonth(dateStart: String, dateEnd: String) : List<EventModel> {
        return eventsListRepo.getEventsInMonth(dateStart, dateEnd)
    }

    suspend fun searchEvents(title: String) : List<EventModel> {
        return eventsListRepo.searchEvents(title)
    }

    suspend fun onFavClicked(id_event: Int, isFavorite: Boolean) {
        eventsListRepo.favClicked(id_event, isFavorite)
    }

    suspend fun onFavDeleteClicked(idEvent: Int) {
        eventsListRepo.favClicked(idEvent, false)
    }

    suspend fun getSelectedDatesList() : List<EventDateModel> {
        Log.w("error", "error 2")
        return eventsListRepo.getEventsDates()
    }
}