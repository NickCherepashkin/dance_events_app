package com.drozdova.danceevents.domain.repository

interface CalendarRepo {
    fun getListOgYears() : List<Int>
}