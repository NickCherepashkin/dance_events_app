package com.drozdova.danceevents.data.repository

import android.util.Log
import com.drozdova.danceevents.data.ApiService
import com.drozdova.danceevents.data.database.bean.EventEntity
import com.drozdova.danceevents.data.database.bean.FavEntity
import com.drozdova.danceevents.data.database.dao.EventsDAO
import com.drozdova.danceevents.data.database.dao.FavesDAO
import com.drozdova.danceevents.data.model.Fav
import com.drozdova.danceevents.domain.repository.EventsRepo
import com.drozdova.danceevents.presentation.model.EventModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
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

                val format: DateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.ROOT)
                val dateStart = format.format(entity.dateStart)
                val dateEnd = format.format(entity.dateEnd)

                EventModel(
                    entity.id,
                    entity.title,
                    dateStart,
                    dateEnd,
                    entity.description,
                    entity.location,
                    entity.contacts,
                    entity.photo,
                    entity.isFavorite ?:false
                )
            }
        }
    }


    override suspend fun getFavEventsList() {
        return withContext(Dispatchers.IO) {
//            if(!favesDAO.doesFavEntityExsists()) {
                val response = apiService.getAllFaves()
                response.body()?.favesList?.let { list ->
                    list.map { fav ->
                        val favEntity = FavEntity(
                            fav.idUser,
                            fav.idEvent,
                            fav.id
                        )
                        favesDAO.insertFavEntity(favEntity)
                        eventsDAO.addToFavorite(favEntity.id_event, true)
                    }
                }
//            }
        }
    }

    override suspend fun showFavEvents(): Flow<List<EventModel>> {
        return withContext(Dispatchers.IO) {
            val favEntity = favesDAO.getFavEntity()
            favEntity.map { list ->
                list.map { entity ->
                    val format = SimpleDateFormat("dd.MM.yyyy", Locale.ROOT)
                    val dateStart = format.format(entity.dateStart)
                    val dateEnd = format.format(entity.dateEnd)
                    EventModel(
                        entity.id,
                        entity.title,
                        dateStart,
                        dateEnd,
                        entity.description,
                        entity.location,
                        entity.contacts,
                        entity.photo,
                        entity.isFavorite ?:false
                    )
                }
            }
        }
    }

    override suspend fun favClicked(id_event: Int, isFavorite: Boolean) {
        return withContext(Dispatchers.IO) {
            eventsDAO.addToFavorite(id_event, isFavorite)
            val fav = Fav(1, id_event)
            when(isFavorite) {
                true -> apiService.insertFav(fav)
                false -> {
                    apiService.deleteFav(fav)
                    favesDAO.deleteFavEntity(fav.idUser, fav.idEvent)
                }
            }
        }
    }

    override suspend fun favDelete(idUser: Int, idEvent: Int) {
        return withContext(Dispatchers.IO) {
            val fav = Fav(idUser, idEvent)
            favesDAO.deleteFavEntity(fav.idUser, fav.idEvent)
            apiService.deleteFav(fav)
        }
    }


    override suspend fun getEventsInMonth(dateStart: String, dateEnd: String): List<EventModel> {
        return withContext(Dispatchers.IO) {

            val format = SimpleDateFormat("dd.MM.yyyy", Locale.ROOT)
            val startEventLong = format.parse(dateStart)!!.time
            val endEventLong = format.parse(dateEnd)!!.time
            val eventsEntity = eventsDAO.findEventsByDates(startEventLong, endEventLong)
            eventsEntity.map { event ->

                val dateStartEvent = format.format(event.dateStart)
                val dateEndEvent = format.format(event.dateEnd)
                EventModel(
                    event.id,
                    event.title,
                    dateStartEvent,
                    dateEndEvent,
                    event.description,
                    event.location,
                    event.contacts,
                    event.photo,
                    event.isFavorite ?: false
                )
            }
        }
    }

    override suspend fun searchEvents(title: String): List<EventModel> {
        return withContext(Dispatchers.IO) {
            val eventsEntity = eventsDAO.findEventsByTitle(title)
            eventsEntity.map { event ->
                val format = SimpleDateFormat("dd.MM.yyyy", Locale.ROOT)
                val dateStart = format.format(event.dateStart)
                val dateEnd = format.format(event.dateEnd)
                EventModel(
                    event.id,
                    event.title,
                    dateStart,
                    dateEnd,
                    event.description,
                    event.location,
                    event.contacts,
                    event.photo,
                    event.isFavorite ?: false
                )
            }
        }
    }
}