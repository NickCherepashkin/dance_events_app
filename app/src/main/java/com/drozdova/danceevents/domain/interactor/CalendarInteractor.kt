package com.drozdova.danceevents.domain.interactor

import com.drozdova.danceevents.domain.repository.CalendarRepo

class CalendarInteractor(
    private val calendarRepo: CalendarRepo
) {
    fun getListOfYears() : List<Int> {
        return calendarRepo.getListOfYears()
    }
}