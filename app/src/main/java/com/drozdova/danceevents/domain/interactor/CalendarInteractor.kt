package com.drozdova.danceevents.domain.interactor

import com.drozdova.danceevents.domain.repository.CalendarRepo
import com.drozdova.danceevents.domain.repository.EventsRepo
import com.drozdova.danceevents.presentation.model.EventModel

class CalendarInteractor(
    private val calendarRepo: CalendarRepo
) {
    fun getListOfYears() : List<Int> {
        return calendarRepo.getListOgYears()
    }
}