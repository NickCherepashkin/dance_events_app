package com.drozdova.danceevents.data

import com.drozdova.danceevents.data.model.EventsResponse
import com.drozdova.danceevents.data.model.FavResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/dance_events_server/events")
    suspend fun getAllEvents(): Response<EventsResponse>

    @GET("/dance_events_server/fav_events")
    suspend fun getAllFaves(): Response<FavResponse>
}