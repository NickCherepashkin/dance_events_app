package com.drozdova.danceevents.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.drozdova.danceevents.data.database.bean.EventEntity

@Dao
interface EventsDAO {
    @Insert
    fun insertEventsEntity(eventEntity: EventEntity)

    @Query("Select(Select COUNT(*) from events) != 0")
    fun doesEventsEntityExsists() : Boolean

    @Query("Select * from events")
    fun getEventsEntity(): List<EventEntity>
}