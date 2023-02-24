package com.drozdova.danceevents.presentation.view.events

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.drozdova.danceevents.R
import com.drozdova.danceevents.data.EventsRepoImpl
import com.drozdova.danceevents.databinding.FragmentMonthWithEventsBinding
import com.drozdova.danceevents.domain.interactor.EventsInteractor
import com.drozdova.danceevents.presentation.model.EventModel
import com.drozdova.danceevents.presentation.view.listener.EventListener
import java.util.*

class MonthWithEventsFragment : Fragment(), EventListener {
    private var _binding: FragmentMonthWithEventsBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: MonthWithEventsAdapter
    private lateinit var interactor: EventsInteractor

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMonthWithEventsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        interactor = EventsInteractor(EventsRepoImpl())

        val calendar = Calendar.getInstance()
        calendar.set(
            2024,
            4,
            1
        )
        binding.cvMonth.date = calendar.timeInMillis

        adapter = MonthWithEventsAdapter(this)
        binding.rvEventsInMonth.adapter = adapter

        val list = interactor.getEventsInMonth(calendar.toString())

        adapter.submit(list)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun showDetails(event: EventModel) {
        findNavController().navigate(R.id.action_monthWithEventsFragment_to_eventInfoFragment)
    }
}