package com.drozdova.danceevents.data.database.bean

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "events")
data class EventEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "dateStart")
    val dateStart: String,
    @ColumnInfo(name = "dateEnd")
    val dateEnd: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "location")
    val location: String,
    @ColumnInfo(name = "contacts")
    val contacts: String,
    @ColumnInfo(name = "photo")
    val photo: String
)
