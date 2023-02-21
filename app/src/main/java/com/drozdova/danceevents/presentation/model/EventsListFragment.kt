package com.drozdova.danceevents.presentation.model

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.drozdova.danceevents.R
import com.drozdova.danceevents.databinding.FragmentEventsListBinding
import com.drozdova.danceevents.presentation.model.model.EventModel

class EventsListFragment : Fragment(), EventListener {
    private var _binding: FragmentEventsListBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: EventsListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEventsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = EventsListAdapter(this)
        binding.rvEventsList.adapter = adapter
        val list = listOf(
            EventModel("Winter Cup 2023", "25.02.2023", "26.02.2023"),
            EventModel("Child and Youth Week", "25.02.2023", "26.02.2023"),
            EventModel("Minsk Cup", "25.02.2023", "26.02.2023"),
            EventModel("All2TheStep", "25.02.2023", "26.02.2023"),
            EventModel("GolJun", "25.02.2023", "26.02.2023"),
            EventModel("Christmas Stars", "25.02.2023", "26.02.2023"),
            EventModel("Mooving Up", "25.02.2023", "26.02.2023"),
        )

        adapter.submit(list)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun showDetails() {
        findNavController().navigate(R.id.action_eventsListFragment_to_eventInfoFragment2)
    }
}