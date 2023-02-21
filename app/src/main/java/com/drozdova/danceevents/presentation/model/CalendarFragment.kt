package com.drozdova.danceevents.presentation.model

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.drozdova.danceevents.R
import com.drozdova.danceevents.databinding.FragmentCalendarBinding

class CalendarFragment : Fragment(), MonthListener {
    private var _binding: FragmentCalendarBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: CalendarAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCalendarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = CalendarAdapter(this)
        binding.rvCalendar.adapter = adapter
        val listOfYears = listOf(2023, 2024)
        adapter.submit(listOfYears)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun showMonthWithEvents() {
        findNavController().navigate(R.id.action_calendarFragment_to_monthWithEventsFragment)
    }
}