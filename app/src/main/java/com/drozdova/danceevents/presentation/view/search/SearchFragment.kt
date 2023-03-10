package com.drozdova.danceevents.presentation.view.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.drozdova.danceevents.R
import com.drozdova.danceevents.databinding.FragmentSearchBinding
import com.drozdova.danceevents.presentation.model.EventModel
import com.drozdova.danceevents.presentation.view.listener.SearchListener
import com.drozdova.danceevents.presentation.viewmodel.SearchViewModel
import com.drozdova.danceevents.utils.BundleConstants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment(), SearchListener {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: SearchAdapter

    private val viewModel: SearchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.svEvents.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.searchEventsList(newText?:"")
                return false
            }
        })

        adapter = SearchAdapter(this)
        binding.rvSearchEvents.adapter = adapter

        viewModel.searchList.observe(viewLifecycleOwner) { list ->
            adapter.submit(list)
        }

        viewModel.bundle.observe(viewLifecycleOwner) { event ->
            if (event != null) {
                val bundle = Bundle()
                bundle.putString(BundleConstants.EVENT_TITLE, event.title)
                bundle.putString(BundleConstants.EVENT_DATE_START, event.dateStart)
                bundle.putString(BundleConstants.EVENT_DATE_END, event.dateEnd)
                bundle.putString(BundleConstants.EVENT_LOCATION, event.location)
                bundle.putString(BundleConstants.EVENT_CONTACTS, event.contacts)
                bundle.putString(BundleConstants.EVENT_PHOTO, event.photo)
                bundle.putString(BundleConstants.EVENT_DESCRIPTION, event.description)

                findNavController().navigate(R.id.action_searchFragment_to_eventInfoFragment4, bundle)
                viewModel.onBack()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun showDetails(event: EventModel) {
        viewModel.showEventInfo(event)
    }
}