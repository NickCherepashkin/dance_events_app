package com.drozdova.danceevents.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.drozdova.danceevents.data.database.bean.EventEntity
import com.drozdova.danceevents.data.database.bean.FavEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavesDAO {
    @Insert
    fun insertFavEntity(favEntity: FavEntity)

    @Query("Select(Select COUNT(*) from fav_events) != 0")
    fun doesFavEntityExsists() : Boolean

    @Query("Select events.* from events, fav_events where fav_events.id_user = 1 and fav_events.id_event = events.id")
    fun getFavEntity(): Flow<List<EventEntity>>

    @Query("Delete from fav_events where id_user = :idUser and id_event = :idEvent")
    fun deleteFavEntity(idUser: Int, idEvent: Int)

    @Query("Delete from fav_events")
    fun clearFavTable()
}