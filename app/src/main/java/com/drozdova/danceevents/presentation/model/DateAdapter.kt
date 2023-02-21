package com.drozdova.danceevents.presentation.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.drozdova.danceevents.databinding.DateItemBinding

class DateAdapter(
    private val monthListener: MonthListener
) : RecyclerView.Adapter<DateViewHolder>() {
    private var _binding: DateItemBinding? = null
    private val binding get() = _binding!!

    private var days: Int = 0
    private var year: Int = 0
    private var spaces: Int = 0

    fun submit(days: Int, year: Int, spaces: Int) {
        this.days = days
        this.year = year
        this.spaces = spaces
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateViewHolder {
        _binding = DateItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DateViewHolder(binding, monthListener)
    }

    override fun onBindViewHolder(holder: DateViewHolder, position: Int) {
        holder.bind(days, position, year, spaces)
    }

    override fun getItemCount(): Int {
        return days + spaces
    }
}