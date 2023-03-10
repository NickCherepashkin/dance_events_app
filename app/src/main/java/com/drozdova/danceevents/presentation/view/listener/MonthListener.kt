package com.drozdova.danceevents.presentation.view.listener

interface MonthListener {
    fun showMonthWithEvents(year: Int, month: Int)
    fun selectDate(day: Int, month: Int, year: Int) : Boolean
}