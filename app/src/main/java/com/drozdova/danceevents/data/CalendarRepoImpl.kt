package com.drozdova.danceevents.data

import com.drozdova.danceevents.domain.repository.CalendarRepo
import com.drozdova.danceevents.presentation.model.EventModel
import java.util.*

class CalendarRepoImpl: CalendarRepo {
    override fun getListOfYears() : List<Int>{
        val calendar: Calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        return listOf(year, (year + 1))
    }
}