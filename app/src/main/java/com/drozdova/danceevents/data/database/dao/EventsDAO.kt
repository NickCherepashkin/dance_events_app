package com.drozdova.danceevents.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.drozdova.danceevents.data.database.bean.EventEntity
import com.drozdova.danceevents.data.model.EventDatesRange

@Dao
interface EventsDAO {
    @Insert
    fun insertEventsEntity(eventEntity: EventEntity)

    @Query("Select(Select COUNT(*) from events) != 0")
    fun doesEventsEntityExsists() : Boolean

    @Query("Select * from events")
    fun getEventsEntity() : List<EventEntity>

    @Query("Update events set isFavorite = :isFavorite where id = :id_event")
    fun addToFavorite(id_event: Int, isFavorite: Boolean)

    @Query("Select * from events where title like '%' || :title || '%'")
    fun findEventsByTitle(title: String) : List<EventEntity>

    @Query("Select * from events where (dateStart BETWEEN :dateStart AND :dateEnd) or (dateEnd BETWEEN :dateStart AND :dateEnd) ")
    fun findEventsByDates(dateStart: Long, dateEnd: Long) : List<EventEntity>

    @Query("Select dateStart, dateEnd from events")
    fun getEventDatesList() : List<EventDatesRange>

    @Query("Delete from events")
    fun clearEventsTable()
}