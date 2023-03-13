package com.drozdova.danceevents.presentation.view.events

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.drozdova.danceevents.R
import com.drozdova.danceevents.databinding.FragmentEventsListBinding
import com.drozdova.danceevents.presentation.model.EventModel
import com.drozdova.danceevents.presentation.view.listener.EventListener
import com.drozdova.danceevents.presentation.viewmodel.EventsViewModel
import com.drozdova.danceevents.utils.BundleConstants
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class EventsListFragment : Fragment(), EventListener {
    private var _binding: FragmentEventsListBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: EventsListAdapter

    private val viewModel: EventsViewModel by viewModels()

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

        viewModel.showEventsList()

        viewModel.eventsList.observe(viewLifecycleOwner){ list ->
            Log.w("LIST", list.toString())
            adapter.submit(list)
        }

        viewModel.bundle.observe(viewLifecycleOwner){ event ->
            if(event != null) {
                val bundle = Bundle()
                bundle.putString(BundleConstants.EVENT_TITLE, event.title)
                bundle.putString(BundleConstants.EVENT_DATE_START, event.dateStart)
                bundle.putString(BundleConstants.EVENT_DATE_END, event.dateEnd)
                bundle.putString(BundleConstants.EVENT_LOCATION, event.location)
                bundle.putString(BundleConstants.EVENT_CONTACTS, event.contacts)
                bundle.putString(BundleConstants.EVENT_PHOTO, event.photo)
                bundle.putString(BundleConstants.EVENT_DESCRIPTION, event.description)

                findNavController().navigate(R.id.action_eventsListFragment_to_eventInfoFragment2, bundle)
                viewModel.onBack()
            }
        }

        viewModel.errorMessage.observe(viewLifecycleOwner) { message ->
            Toast.makeText(context, getString(message), Toast.LENGTH_LONG).show()
        }

        viewModel.visibility.observe(viewLifecycleOwner) {
            binding.messNotEvents.visibility = it
        }
    }

    override fun showDetails(event: EventModel) {
        viewModel.showEventInfo(event)
    }

    override fun onFavClicked(id: Int, isFavorite: Boolean) {
        viewModel.onFavClicked(id, isFavorite)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}