package com.drozdova.danceevents.data

import com.drozdova.danceevents.domain.repository.EventsRepo
import com.drozdova.danceevents.presentation.model.EventModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class EventsRepoImpl @Inject constructor() : EventsRepo {
    override suspend fun getEventsList(): List<EventModel> {
        return withContext(Dispatchers.IO) {
            listOf(
                EventModel(1, "Winter Cup 2023", "25.02.2023", "26.02.2023", "kfdlsg lgdsfg gldsigf g;jipdsfug gfd;spi;ug", "IDO"),
                EventModel(2,"Child and Youth Week", "25.02.2023", "26.02.2023", "kfdlsg lgdsfg gldsigf g;jipdsfug gfd;spi;ug", "IDO"),
                EventModel(3,"Minsk Cup", "25.02.2023", "26.02.2023", "kfdlsg lgdsfg gldsigf g;jipdsfug gfd;spi;ug", "IDO"),
                EventModel(4,"All2TheStep", "25.02.2023", "26.02.2023", "kfdlsg lgdsfg gldsigf g;jipdsfug gfd;spi;ug", "IDO"),
                EventModel(5,"GolJun", "25.02.2023", "26.02.2023", "kfdlsg lgdsfg gldsigf g;jipdsfug gfd;spi;ug", "IDO"),
                EventModel(6,"Christmas Stars", "25.02.2023", "26.02.2023", "kfdlsg lgdsfg gldsigf g;jipdsfug gfd;spi;ug", "IDO"),
                EventModel(7,"Mooving Up", "25.02.2023", "26.02.2023", "kfdlsg lgdsfg gldsigf g;jipdsfug gfd;spi;ug", "IDO"),
                EventModel(8,"Child and Youth Week", "25.02.2023", "26.02.2023", "kfdlsg lgdsfg gldsigf g;jipdsfug gfd;spi;ug", "IDO"),
                EventModel(9,"Minsk Cup", "25.02.2023", "26.02.2023", "kfdlsg lgdsfg gldsigf g;jipdsfug gfd;spi;ug", "IDO"),
                EventModel(10,"All2TheStep", "25.02.2023", "26.02.2023", "kfdlsg lgdsfg gldsigf g;jipdsfug gfd;spi;ug", "IDO"),
                EventModel(11,"GolJun", "25.02.2023", "26.02.2023", "kfdlsg lgdsfg gldsigf g;jipdsfug gfd;spi;ug", "IDO")
            )
        }
    }

    override suspend fun getFavEventsList(): List<EventModel> {
        return withContext(Dispatchers.IO) {
            listOf(
                EventModel(1, "Winter Cup 2023", "25.02.2023", "26.02.2023", "kfdlsg lgdsfg gldsigf g;jipdsfug gfd;spi;ug", "IDO"),
                EventModel(2,"Child and Youth Week", "25.02.2023", "26.02.2023", "kfdlsg lgdsfg gldsigf g;jipdsfug gfd;spi;ug", "IDO"),
                EventModel(3,"Minsk Cup", "25.02.2023", "26.02.2023", "kfdlsg lgdsfg gldsigf g;jipdsfug gfd;spi;ug", "IDO"),
                EventModel(4,"All2TheStep", "25.02.2023", "26.02.2023", "kfdlsg lgdsfg gldsigf g;jipdsfug gfd;spi;ug", "IDO"),
                EventModel(10,"All2TheStep", "25.02.2023", "26.02.2023", "kfdlsg lgdsfg gldsigf g;jipdsfug gfd;spi;ug", "IDO"),
                EventModel(11,"GolJun", "25.02.2023", "26.02.2023", "kfdlsg lgdsfg gldsigf g;jipdsfug gfd;spi;ug", "IDO")
            )
        }
    }

    override suspend fun getEventsInMonth(date: String): List<EventModel> {
        return withContext(Dispatchers.IO) {
            listOf(
                EventModel(1, "Winter Cup 2023", "25.02.2023", "26.02.2023", "kfdlsg lgdsfg gldsigf g;jipdsfug gfd;spi;ug", "IDO"),
                EventModel(4,"All2TheStep", "25.02.2023", "26.02.2023", "kfdlsg lgdsfg gldsigf g;jipdsfug gfd;spi;ug", "IDO"),
                EventModel(10,"All2TheStep", "25.02.2023", "26.02.2023", "kfdlsg lgdsfg gldsigf g;jipdsfug gfd;spi;ug", "IDO"),
                EventModel(11,"GolJun", "25.02.2023", "26.02.2023", "kfdlsg lgdsfg gldsigf g;jipdsfug gfd;spi;ug", "IDO")
            )
        }
    }

    override suspend fun searchEvents(title: String): List<EventModel> {
        return withContext(Dispatchers.IO) {
            listOf(
                EventModel(1, "Winter Cup 2023", "25.02.2023", "26.02.2023", "kfdlsg lgdsfg gldsigf g;jipdsfug gfd;spi;ug", "IDO"),
                EventModel(9,"Minsk Cup", "25.02.2023", "26.02.2023", "kfdlsg lgdsfg gldsigf g;jipdsfug gfd;spi;ug", "IDO"),
                EventModel(10,"All2TheStep", "25.02.2023", "26.02.2023", "kfdlsg lgdsfg gldsigf g;jipdsfug gfd;spi;ug", "IDO"),
                EventModel(11,"GolJun", "25.02.2023", "26.02.2023", "kfdlsg lgdsfg gldsigf g;jipdsfug gfd;spi;ug", "IDO")
            )
        }
    }
}