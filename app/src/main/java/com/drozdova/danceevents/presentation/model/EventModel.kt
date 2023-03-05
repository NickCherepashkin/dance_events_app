package com.drozdova.danceevents.presentation.model

data class EventModel (
        val id: Int,
        val title: String,
        val dateStart: String,
        val dateEnd: String,
        val description: String,
        val location: String,
        val contacts: String,
        val photo: String,
        val isFavorite: Boolean
)