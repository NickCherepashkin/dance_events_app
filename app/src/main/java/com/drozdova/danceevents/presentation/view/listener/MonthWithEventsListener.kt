package com.drozdova.danceevents.presentation.view.listener

import com.drozdova.danceevents.presentation.model.EventModel

interface MonthWithEventsListener {
    fun showDetails(event: EventModel)
}