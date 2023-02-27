package com.drozdova.danceevents.presentation.view.events

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.drozdova.danceevents.R
import com.drozdova.danceevents.databinding.FragmentMonthWithEventsBinding
import com.drozdova.danceevents.presentation.model.EventModel
import com.drozdova.danceevents.presentation.view.listener.EventListener
import com.drozdova.danceevents.presentation.viewmodel.MonthWithEventsViewModel
import com.drozdova.danceevents.utils.BundleConstants
import java.util.*

class MonthWithEventsFragment : Fragment(), EventListener {
    private var _binding: FragmentMonthWithEventsBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: MonthWithEventsAdapter

    private val viewModel: MonthWithEventsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMonthWithEventsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var year = 0
        var month = 0
        val bundle = arguments
        bundle?.let { safeBundle ->
            year = safeBundle.getInt(BundleConstants.CALENDAR_YEAR)
            month = safeBundle.getInt(BundleConstants.CALENDAR_MONTH)
        }

        val date = "01.${month + 1}.${year}"
        val calendar = Calendar.getInstance()
        calendar.set(year, month, 1)

        binding.cvMonth.date = calendar.timeInMillis

        adapter = MonthWithEventsAdapter(this)
        binding.rvEventsInMonth.adapter = adapter

        viewModel.showEventsInMonth(date)

        viewModel.eventsListInMonth.observe(viewLifecycleOwner){ list ->
            adapter.submit(list)
        }

        viewModel.bundle.observe(viewLifecycleOwner){ event ->
            if (event != null) {
                val bundle = Bundle()
                bundle.putString(BundleConstants.EVENT_TITLE, event.title)
                bundle.putString(BundleConstants.EVENT_DATE_START, event.dateStart)
                bundle.putString(BundleConstants.EVENT_DATE_END, event.dateEnd)
                bundle.putString(BundleConstants.EVENT_DESCRIPTION, event.description)

                findNavController().navigate(R.id.action_monthWithEventsFragment_to_eventInfoFragment, bundle)
                viewModel.onBack()
            }
        }
    }

    override fun showDetails(event: EventModel) {
        viewModel.showEventInfo(event)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}