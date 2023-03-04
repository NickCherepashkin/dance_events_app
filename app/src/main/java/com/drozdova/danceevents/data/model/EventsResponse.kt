package com.drozdova.danceevents.data.model

import com.drozdova.danceevents.data.model.Event
import com.google.gson.annotations.SerializedName

data class EventsResponse(
    @SerializedName("allEvents")
    val eventsList: List<Event>
)
