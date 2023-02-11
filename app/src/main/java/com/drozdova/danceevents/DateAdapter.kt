package com.drozdova.danceevents

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.drozdova.danceevents.databinding.DateItemBinding

class DateAdapter : RecyclerView.Adapter<DateViewHolder>() {
    private var _binding: DateItemBinding? = null
    private val binding get() = _binding!!

    private var days: Int = 0
    private var year: Int = 0
    private var spaces: Int = 0

    fun submit(days: Int, pos: Int, Y: Int, spaces: Int) {
        this.days = days
        year = Y
        this.spaces = spaces
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateViewHolder {
        _binding = DateItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DateViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DateViewHolder, position: Int) {
        holder.bind(days, position, year, spaces)
    }

    override fun getItemCount(): Int {
        return days + spaces
    }
}