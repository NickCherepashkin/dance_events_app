package com.drozdova.danceevents.domain.repository

interface CalendarRepo {
    fun getListOfYears() : List<Int>
}