package com.drozdova.danceevents.presentation.view.calendar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.drozdova.danceevents.R
import com.drozdova.danceevents.databinding.FragmentCalendarBinding
import com.drozdova.danceevents.presentation.model.EventDateModel
import com.drozdova.danceevents.presentation.view.listener.MonthListener
import com.drozdova.danceevents.presentation.viewmodel.CalendarViewModel
import com.drozdova.danceevents.utils.BundleConstants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CalendarFragment : Fragment(), MonthListener {
    private var _binding: FragmentCalendarBinding? = null
    private val binding get() = _binding!!
    private lateinit var selectedDatesList: List<EventDateModel>

    private lateinit var adapter: CalendarAdapter

    private val viewModel: CalendarViewModel by viewModels()

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
        selectedDatesList = emptyList()
        adapter.submit()

        viewModel.getEventsList()

        viewModel.listOfEventsDates.observe(viewLifecycleOwner) { list ->
            selectedDatesList = list
            adapter.submit()
        }

        viewModel.errorMessage.observe(viewLifecycleOwner) { message ->
            Toast.makeText(context, getString(message), Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun showMonthWithEvents(year: Int, month: Int) {
        val bundle = Bundle()
        bundle.putInt(BundleConstants.CALENDAR_YEAR, year)
        bundle.putInt(BundleConstants.CALENDAR_MONTH, month)
        findNavController().navigate(R.id.action_calendarFragment_to_monthWithEventsFragment, bundle)
    }

    override fun selectDate(day: Int, month: Int, year: Int): Boolean {
        val eventDateModel = EventDateModel(day, month + 1, year)
        return when(day) {
            0 -> false
            else -> selectedDatesList.contains(eventDateModel)
        }
    }
}