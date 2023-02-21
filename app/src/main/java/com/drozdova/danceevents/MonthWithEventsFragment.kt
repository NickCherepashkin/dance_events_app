package com.drozdova.danceevents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.drozdova.danceevents.databinding.FragmentMonthWithEventsBinding
import com.drozdova.danceevents.model.EventModel
import java.util.*

class MonthWithEventsFragment : Fragment(), EventListener {
    private var _binding: FragmentMonthWithEventsBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: MonthWithEventsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMonthWithEventsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val calendar = Calendar.getInstance()
        calendar.set(
            2024,
            4,
            1
        )
        binding.cvMonth.date = calendar.timeInMillis

        adapter = MonthWithEventsAdapter(this)
        binding.rvEventsInMonth.adapter = adapter

        val list = listOf(
            EventModel("Winter Cup 2023", "25.02.2023", "26.02.2023"),
            EventModel("Child and Youth Week", "25.02.2023", "26.02.2023"),
            EventModel("Minsk Cup", "25.02.2023", "26.02.2023"),
            EventModel("All2TheStep", "25.02.2023", "26.02.2023"),
            EventModel("GolJun", "25.02.2023", "26.02.2023"),
            EventModel("Winter Cup 2023", "25.02.2023", "26.02.2023"),
            EventModel("Child and Youth Week", "25.02.2023", "26.02.2023"),
            EventModel("Minsk Cup", "25.02.2023", "26.02.2023"),
            EventModel("All2TheStep", "25.02.2023", "26.02.2023"),
            EventModel("GolJun", "25.02.2023", "26.02.2023")
        )

        adapter.submit(list)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun showDetails() {
        findNavController().navigate(R.id.action_monthWithEventsFragment_to_eventInfoFragment)
    }
}