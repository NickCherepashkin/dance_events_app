package com.drozdova.danceevents.data.model

import com.google.gson.annotations.SerializedName

data class FavResponse (
    @SerializedName("allFaves")
    val favesList: List<Fav>
)