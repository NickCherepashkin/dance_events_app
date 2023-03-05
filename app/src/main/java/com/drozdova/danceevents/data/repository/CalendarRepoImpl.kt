package com.drozdova.danceevents.data.repository

import com.drozdova.danceevents.domain.repository.CalendarRepo
import com.drozdova.danceevents.presentation.model.EventModel
import java.util.*
import javax.inject.Inject

class CalendarRepoImpl @Inject constructor(): CalendarRepo {
    override fun getListOfYears() : List<Int>{
        return emptyList()
    }
}