package com.drozdova.danceevents.data.repository

import com.drozdova.danceevents.data.ApiService
import com.drozdova.danceevents.data.model.Event
import com.drozdova.danceevents.data.model.EventsResponse
import com.drozdova.danceevents.domain.repository.EventsRepo
import com.drozdova.danceevents.presentation.model.EventModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class EventsRepoImpl @Inject constructor(
    private val apiService: ApiService
) : EventsRepo {
    override suspend fun getEventsList(): List<EventModel> {
        val response = apiService.getAllEvents()
        return withContext(Dispatchers.IO){
            response.body()?.eventsList?.let { list ->
                list.map { event ->
                    EventModel(
                        event.id,
                        event.title,
                        event.dateStart,
                        event.dateEnd,
                        event.description,
                        event.location,
                        event.contacts,
                        event.photo
                    )
                }
            } ?: kotlin.run {
                emptyList()
            }
        }
    }

    override suspend fun getFavEventsList(): List<EventModel> {
        return withContext(Dispatchers.IO) {
            listOf(
//                EventModel(1, "Winter Cup 2023", "25.02.2023", "26.02.2023", "kfdlsg lgdsfg gldsigf g;jipdsfug gfd;spi;ug", "IDO"),
//                EventModel(2,"Child and Youth Week", "25.02.2023", "26.02.2023", "kfdlsg lgdsfg gldsigf g;jipdsfug gfd;spi;ug", "IDO"),
//                EventModel(3,"Minsk Cup", "25.02.2023", "26.02.2023", "kfdlsg lgdsfg gldsigf g;jipdsfug gfd;spi;ug", "IDO"),
//                EventModel(4,"All2TheStep", "25.02.2023", "26.02.2023", "kfdlsg lgdsfg gldsigf g;jipdsfug gfd;spi;ug", "IDO"),
//                EventModel(10,"All2TheStep", "25.02.2023", "26.02.2023", "kfdlsg lgdsfg gldsigf g;jipdsfug gfd;spi;ug", "IDO"),
//                EventModel(11,"GolJun", "25.02.2023", "26.02.2023", "kfdlsg lgdsfg gldsigf g;jipdsfug gfd;spi;ug", "IDO")
            )
        }
    }

    override suspend fun getEventsInMonth(date: String): List<EventModel> {
        return withContext(Dispatchers.IO) {
            listOf(
//                EventModel(1, "Winter Cup 2023", "25.02.2023", "26.02.2023", "kfdlsg lgdsfg gldsigf g;jipdsfug gfd;spi;ug", "IDO"),
//                EventModel(4,"All2TheStep", "25.02.2023", "26.02.2023", "kfdlsg lgdsfg gldsigf g;jipdsfug gfd;spi;ug", "IDO"),
//                EventModel(10,"All2TheStep", "25.02.2023", "26.02.2023", "kfdlsg lgdsfg gldsigf g;jipdsfug gfd;spi;ug", "IDO"),
//                EventModel(11,"GolJun", "25.02.2023", "26.02.2023", "kfdlsg lgdsfg gldsigf g;jipdsfug gfd;spi;ug", "IDO")
            )
        }
    }

    override suspend fun searchEvents(title: String): List<EventModel> {
        return withContext(Dispatchers.IO) {
            listOf(
//                EventModel(1, "Winter Cup 2023", "25.02.2023", "26.02.2023", "kfdlsg lgdsfg gldsigf g;jipdsfug gfd;spi;ug", "IDO"),
//                EventModel(9,"Minsk Cup", "25.02.2023", "26.02.2023", "kfdlsg lgdsfg gldsigf g;jipdsfug gfd;spi;ug", "IDO"),
//                EventModel(10,"All2TheStep", "25.02.2023", "26.02.2023", "kfdlsg lgdsfg gldsigf g;jipdsfug gfd;spi;ug", "IDO"),
//                EventModel(11,"GolJun", "25.02.2023", "26.02.2023", "kfdlsg lgdsfg gldsigf g;jipdsfug gfd;spi;ug", "IDO")
            )
        }
    }
}