package com.drozdova.danceevents

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.drozdova.danceevents.databinding.MonthItemBinding
import java.util.*

class MonthAdapter : RecyclerView.Adapter<MonthViewHolder>() {
    private var _binding: MonthItemBinding? = null
    private val binding get() = _binding!!

    private var listOfMonths = listOf<String>()
    private var listOfYears = listOf<Int>()

    fun submit(listOfMonths: List<String>) {
        this.listOfMonths = listOfMonths
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonthViewHolder {
        _binding = MonthItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MonthViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MonthViewHolder, position: Int) {

        val pos = position + 1
        val days = when(position) {
            1 -> 28
            0, 2, 4, 6, 7, 9, 11 -> 31
            else -> 30
        }

        val calendar = Calendar.getInstance()
        calendar.set(2023, position,0)
        val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
        val spaces = dayOfWeek - 1

        holder.bind(listOfMonths[position], days,pos, 2023, spaces)
    }

    override fun getItemCount(): Int {
        return listOfMonths.size
    }
}