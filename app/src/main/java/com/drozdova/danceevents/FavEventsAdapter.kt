package com.drozdova.danceevents

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.drozdova.danceevents.databinding.ItemEventHorBinding

class FavEventsAdapter : RecyclerView.Adapter<FavEventsHolder>() {
    private var _binding: ItemEventHorBinding? = null
    private val binding get() = _binding!!

    private var listFavEvents = listOf<String>()

    fun submit(listFavEvents: List<String>) {
        this.listFavEvents = listFavEvents
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavEventsHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: FavEventsHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}