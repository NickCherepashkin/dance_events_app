package com.drozdova.danceevents.data.database.bean

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import java.util.*

@Entity(tableName = "events")
data class EventEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "dateStart")
    val dateStart: Long,
    @ColumnInfo(name = "dateEnd")
    val dateEnd: Long,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "location")
    val location: String,
    @ColumnInfo(name = "contacts")
    val contacts: String,
    @ColumnInfo(name = "photo")
    val photo: String,
    @ColumnInfo(name = "isFavorite")
    val isFavorite: Boolean?=false
)
