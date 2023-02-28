package com.drozdova.danceevents.domain.interactor

import com.drozdova.danceevents.domain.repository.CalendarRepo
import javax.inject.Inject

class CalendarInteractor @Inject constructor(
    private val calendarRepo: CalendarRepo
) {
    fun getListOfYears() : List<Int> {
        return calendarRepo.getListOfYears()
    }
}