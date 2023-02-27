package com.drozdova.danceevents.presentation.view.calendar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.drozdova.danceevents.databinding.DateItemBinding
import com.drozdova.danceevents.presentation.view.listener.MonthListener

class DateAdapter(
    private val monthListener: MonthListener
) : RecyclerView.Adapter<DateViewHolder>() {
    private var _binding: DateItemBinding? = null
    private val binding get() = _binding!!

    private var year: Int = 0
    private var month: Int = 0
    private var days: Int = 0
    private var spaces: Int = 0

    fun submit(year: Int, month: Int, days: Int, spaces: Int) {
        this.year = year
        this.month = month
        this.days = days
        this.spaces = spaces
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateViewHolder {
        _binding = DateItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DateViewHolder(binding, monthListener)
    }

    override fun onBindViewHolder(holder: DateViewHolder, position: Int) {
        holder.bind(year, month, spaces, position)
    }

    override fun getItemCount(): Int {
        return days + spaces
    }
}