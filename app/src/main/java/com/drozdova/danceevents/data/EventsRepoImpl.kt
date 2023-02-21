package com.drozdova.danceevents.data

import com.drozdova.danceevents.domain.repository.EventsRepo
import com.drozdova.danceevents.presentation.model.EventModel

class EventsRepoImpl : EventsRepo {
    override fun getEventsList(): List<EventModel> {
        return listOf(
            EventModel("Winter Cup 2023", "25.02.2023", "26.02.2023"),
            EventModel("Child and Youth Week", "25.02.2023", "26.02.2023"),
            EventModel("Minsk Cup", "25.02.2023", "26.02.2023"),
            EventModel("All2TheStep", "25.02.2023", "26.02.2023"),
            EventModel("GolJun", "25.02.2023", "26.02.2023"),
            EventModel("Christmas Stars", "25.02.2023", "26.02.2023"),
            EventModel("Mooving Up", "25.02.2023", "26.02.2023"),
            EventModel("Child and Youth Week", "25.02.2023", "26.02.2023"),
            EventModel("Minsk Cup", "25.02.2023", "26.02.2023"),
            EventModel("All2TheStep", "25.02.2023", "26.02.2023"),
            EventModel("GolJun", "25.02.2023", "26.02.2023")
        )
    }

    override fun getFavEventsList(): List<EventModel> {
        return listOf(
            EventModel("Winter Cup 2023", "25.02.2023", "26.02.2023"),
            EventModel("Child and Youth Week", "25.02.2023", "26.02.2023"),
            EventModel("Minsk Cup", "25.02.2023", "26.02.2023"),
            EventModel("All2TheStep", "25.02.2023", "26.02.2023"),
            EventModel("GolJun", "25.02.2023", "26.02.2023")
        )
    }

    override fun getEventsInMonth(date: String): List<EventModel> {
        return listOf(
            EventModel("Winter Cup 2023", "25.02.2023", "26.02.2023"),
            EventModel("Child and Youth Week", "25.02.2023", "26.02.2023"),
            EventModel("Minsk Cup", "25.02.2023", "26.02.2023"),
            EventModel("All2TheStep", "25.02.2023", "26.02.2023"),
            EventModel("GolJun", "25.02.2023", "26.02.2023"),
            EventModel("Winter Cup 2023", "25.02.2023", "26.02.2023")
        )
    }

    override fun searchEvents(title: String): List<EventModel> {
        return listOf(
            EventModel("Minsk Cup", "25.02.2023", "26.02.2023"),
            EventModel("All2TheStep", "25.02.2023", "26.02.2023"),
            EventModel("GolJun", "25.02.2023", "26.02.2023")
        )
    }
}