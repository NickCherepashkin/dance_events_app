package com.drozdova.danceevents.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.drozdova.danceevents.R
import com.drozdova.danceevents.data.EventsRepoImpl
import com.drozdova.danceevents.databinding.FragmentFavEventsBinding
import com.drozdova.danceevents.domain.interactor.EventsInteractor

class FavEventsFragment : Fragment(), EventListener {
    private var _binding: FragmentFavEventsBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: FavEventsAdapter
    private lateinit var interactor: EventsInteractor

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavEventsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        interactor = EventsInteractor(EventsRepoImpl())

        adapter = FavEventsAdapter(this)
        binding.rvFavorite.adapter = adapter

        val list = interactor.getFavEventsList()

        adapter.submit(list)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun showDetails() {
        findNavController().navigate(R.id.action_favEventsFragment_to_eventInfoFragment3)
    }
}