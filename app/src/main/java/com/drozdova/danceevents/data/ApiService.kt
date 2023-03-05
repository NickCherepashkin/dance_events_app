package com.drozdova.danceevents.data

import com.drozdova.danceevents.data.model.EventsResponse
import com.drozdova.danceevents.data.model.Fav
import com.drozdova.danceevents.data.model.FavResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("/dance_events_server/events")
    suspend fun getAllEvents(): Response<EventsResponse>

    @GET("/dance_events_server/fav_events")
    suspend fun getAllFaves(): Response<FavResponse>

    @POST("/dance_events_server/fav_insert")
    suspend fun insertFav(@Body fav: Fav)

    @POST("/dance_events_server/fav_delete")
    suspend fun deleteFav(@Body fav: Fav)
}