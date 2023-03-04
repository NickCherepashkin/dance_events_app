package com.drozdova.danceevents.data

import com.drozdova.danceevents.data.model.Event
import com.drozdova.danceevents.data.model.EventsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/dance_events_server/events")
    suspend fun getAllEvents(): Response<EventsResponse>
}