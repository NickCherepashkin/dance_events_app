package com.drozdova.danceevents.presentation.view.listener

import com.drozdova.danceevents.presentation.model.EventDateModel

interface MonthListener {
    fun showMonthWithEvents(year: Int, month: Int)
    fun selectDate(day: Int, month: Int, year: Int) : Boolean
}