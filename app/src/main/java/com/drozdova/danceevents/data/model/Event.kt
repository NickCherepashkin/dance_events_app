package com.drozdova.danceevents.data.model

import com.google.gson.annotations.SerializedName

data class Event(
    val id: Int,
    val title: String,
    val dateStart: Long,
    val dateEnd: Long,
    val description: String,
    val location: String,
    val contacts: String,
    @SerializedName("eventPhoto")
    val photo: String
)
