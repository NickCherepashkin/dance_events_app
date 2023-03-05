package com.drozdova.danceevents.data.database.bean

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fav_events")
data class FavEntity (
    @ColumnInfo(name = "id_user")
    val id_user: Int,
    @ColumnInfo(name = "id_event")
    val id_event: Int,
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Int
)