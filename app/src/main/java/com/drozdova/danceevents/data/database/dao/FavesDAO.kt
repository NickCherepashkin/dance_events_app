package com.drozdova.danceevents.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.drozdova.danceevents.data.database.bean.EventEntity
import com.drozdova.danceevents.data.database.bean.FavEntity

@Dao
interface FavesDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertFavEntity(favEntity: FavEntity)

    @Query("Select(Select COUNT(*) from fav_events) != 0")
    fun doesFavEntityExsists() : Boolean

    @Query("Select events.* from events, fav_events where fav_events.id_user = 1 and fav_events.id_event = events.id")
    fun getFavEntity(): List<EventEntity>

    @Query("Delete from fav_events where id_user = :idUser and id_event = :idEvent")
    fun deleteFavEntity(idUser: Int, idEvent: Int)
}