package com.drozdova.danceevents.presentation.view.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.drozdova.danceevents.R
import com.drozdova.danceevents.databinding.FragmentFavEventsBinding
import com.drozdova.danceevents.presentation.model.EventModel
import com.drozdova.danceevents.presentation.view.listener.EventListener
import com.drozdova.danceevents.presentation.viewmodel.FavEventsViewModel
import com.drozdova.danceevents.utils.BundleConstants

class FavEventsFragment : Fragment(), EventListener {
    private var _binding: FragmentFavEventsBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: FavEventsAdapter

    private val viewModel: FavEventsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavEventsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = FavEventsAdapter(this)
        binding.rvFavorite.adapter = adapter

        viewModel.showFavEventsList()

        viewModel.favEventsList.observe(viewLifecycleOwner){ list ->
            adapter.submit(list)
        }

        viewModel.bundle.observe(viewLifecycleOwner){ event ->
            if(event != null) {
                val bundle = Bundle()
                bundle.putString(BundleConstants.EVENT_TITLE, event.title)
                bundle.putString(BundleConstants.EVENT_DATE_START, event.dateStart)
                bundle.putString(BundleConstants.EVENT_DATE_END, event.dateEnd)
                bundle.putString(BundleConstants.EVENT_DESCRIPTION, event.description)

                findNavController().navigate(R.id.action_favEventsFragment_to_eventInfoFragment3, bundle)
                viewModel.onBack()
            }
        }
    }

    override fun showDetails(event: EventModel) {
        viewModel.showFavEventInfo(event)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}