package com.drozdova.danceevents.data.model

import com.google.gson.annotations.SerializedName

data class Event(
    val id: Int,
    val title: String,
    val dateStart: String,
    val dateEnd: String,
    val description: String,
    val location: String,
    val contacts: String,
    @SerializedName("eventPhoto")
    val photo: String
)
