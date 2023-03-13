package com.drozdova.danceevents.data.repository

import android.database.SQLException
import android.util.Log
import com.drozdova.danceevents.data.ApiService
import com.drozdova.danceevents.data.database.bean.EventEntity
import com.drozdova.danceevents.data.database.bean.FavEntity
import com.drozdova.danceevents.data.database.dao.EventsDAO
import com.drozdova.danceevents.data.database.dao.FavesDAO
import com.drozdova.danceevents.data.model.Fav
import com.drozdova.danceevents.domain.repository.EventsRepo
import com.drozdova.danceevents.presentation.model.EventDateModel
import com.drozdova.danceevents.presentation.model.EventModel
import com.drozdova.danceevents.utils.ResultCodes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class EventsRepoImpl @Inject constructor(
    private val apiService: ApiService,
    private val eventsDAO: EventsDAO,
    private val favesDAO: FavesDAO
) : EventsRepo {

    override suspend fun getEventsList() : Int {
        return withContext(Dispatchers.IO){
            try {
                val response = apiService.getAllEvents()
                response.body()?.eventsList?.let { list ->
                    eventsDAO.clearEventsTable()
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
                } ?: kotlin.run {
                    emptyList<EventModel>()
                }
            } catch (error: SQLException) {
                return@withContext ResultCodes.RESULT_SQL_ERROR
            } catch (error: SocketTimeoutException) {
                return@withContext ResultCodes.RESULT_SERVER_CONNECT_ERROR
            } catch (error: ConnectException){
                return@withContext ResultCodes.RESULT_SUCCESS
            }
            return@withContext ResultCodes.RESULT_SUCCESS
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

    override suspend fun getFavEventsList() : Int {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.getAllFaves()
                response.body()?.favesList?.let { list ->
                    favesDAO.clearFavTable()
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
            } catch (error:SQLException) {
                return@withContext ResultCodes.RESULT_SQL_ERROR
            } catch (error: SocketTimeoutException) {
                return@withContext ResultCodes.RESULT_SERVER_CONNECT_ERROR
            }  catch (error: ConnectException){
                return@withContext ResultCodes.RESULT_SUCCESS
            }
            return@withContext ResultCodes.RESULT_SUCCESS
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

    override suspend fun getEventsDates(): List<EventDateModel> {
        return withContext(Dispatchers.IO) {
            val listResult = mutableSetOf<EventDateModel>()
            try {
                val datesRangesList = eventsDAO.getEventDatesList()
                val format = SimpleDateFormat("dd.MM.yyyy", Locale.ROOT)

                Log.w("listDates", datesRangesList.toString())

                datesRangesList.forEach { dateRange ->
                    if (dateRange.dateStart == dateRange.dateEnd) {
                        val date = Date(dateRange.dateStart)
                        val dateMas = format.format(date).split(".")

                        val dateEvent = EventDateModel(
                            dateMas.get(0).toInt(),
                            dateMas.get(1).toInt(),
                            dateMas.get(2).toInt()
                        )
                        listResult.add(dateEvent)
                    } else {
                        val dateStart = Date(dateRange.dateStart)
                        val dateEnd = Date(dateRange.dateEnd)

                        val dateStartMas = format.format(dateStart).split(".")
                        val dateEndMas = format.format(dateEnd).split(".")

                        val dayStart = dateStartMas[0].toInt()
                        val dayEnd = dateEndMas[0].toInt()
                        val monthStart = dateStartMas[1].toInt()
                        val monthEnd = dateEndMas[1].toInt()
                        val year = dateStartMas[2].toInt()

                        if (monthStart == monthEnd) {
                            for ( day in dayStart .. dayEnd) {
                                listResult.add(EventDateModel(day, monthStart, year))
                            }
                        } else {
                            var daysInMonthStart = when(monthStart - 1) {
                                1 -> 28
                                0, 2, 4, 6, 7, 9, 11 -> 31
                                else -> 30
                            }
                            // check for leap year
                            if  ((((year % 4 == 0) && (year % 100 != 0)) ||  (year % 400 == 0)) && monthStart == 1){
                                daysInMonthStart = 29
                            }

                            for (day in dayStart..daysInMonthStart) {
                                listResult.add(EventDateModel(day, monthStart, year))
                            }

                            for (day in 1..dayEnd) {
                                listResult.add(EventDateModel(day, monthEnd, year))
                            }
                        }
                    }
                }
            } catch (e: SQLException) {
                Log.w("listDates", e)
            }

            listResult.toList()
        }
    }
}