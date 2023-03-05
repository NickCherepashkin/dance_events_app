package com.drozdova.danceevents.data.repository

import com.drozdova.danceevents.data.ApiService
import com.drozdova.danceevents.data.database.bean.EventEntity
import com.drozdova.danceevents.data.database.bean.FavEntity
import com.drozdova.danceevents.data.database.dao.EventsDAO
import com.drozdova.danceevents.data.database.dao.FavesDAO
import com.drozdova.danceevents.data.model.Event
import com.drozdova.danceevents.data.model.EventsResponse
import com.drozdova.danceevents.domain.repository.EventsRepo
import com.drozdova.danceevents.presentation.model.EventModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class EventsRepoImpl @Inject constructor(
    private val apiService: ApiService,
    private val eventsDAO: EventsDAO,
    private val favesDAO: FavesDAO
) : EventsRepo {

    override suspend fun getEventsList() {
        return withContext(Dispatchers.IO){
            if(!eventsDAO.doesEventsEntityExsists()) {
                val response = apiService.getAllEvents()
                response.body()?.eventsList?.let { list ->
                    list.map { event ->
                        val eventEntity = EventEntity(
                            event.id,
                            event.title,
                            event.dateStart,
                            event.dateEnd,
                            event.description,
                            event.location,
                            event.contacts,
                            event.photo
                        )
                        eventsDAO.insertEventsEntity(eventEntity)
                    }
                }
            }
        }
    }

    override suspend fun showEventsList(): List<EventModel> {
        return withContext(Dispatchers.IO) {
            val eventEntity = eventsDAO.getEventsEntity()
            eventEntity.map {entity ->
                EventModel(
                    entity.id,
                    entity.title,
                    entity.dateStart,
                    entity.dateEnd,
                    entity.description,
                    entity.location,
                    entity.contacts,
                    entity.photo
                )
            }
        }
    }


    override suspend fun getFavEventsList() {
        return withContext(Dispatchers.IO) {
            if(!favesDAO.doesFavEntityExsists()) {
                val response = apiService.getAllFaves()
                response.body()?.favesList?.let { list ->
                    list.map { fav ->
                        val favEntity = FavEntity(
                            fav.idUser,
                            fav.idEvent
                        )
                        favesDAO.insertFavEntity(favEntity)
                    }
                }
            }
        }
    }

    override suspend fun showFavEvents(): List<EventModel> {
        return withContext(Dispatchers.IO) {
            val favEntity = favesDAO.getFavEntity()
            favEntity.map {entity ->
                EventModel(
                    entity.id,
                    entity.title,
                    entity.dateStart,
                    entity.dateEnd,
                    entity.description,
                    entity.location,
                    entity.contacts,
                    entity.photo
                )
            }
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