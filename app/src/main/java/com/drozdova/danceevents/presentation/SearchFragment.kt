package com.drozdova.danceevents.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.drozdova.danceevents.R
import com.drozdova.danceevents.data.EventsRepoImpl
import com.drozdova.danceevents.databinding.FragmentSearchBinding
import com.drozdova.danceevents.domain.interactor.EventsInteractor

class SearchFragment : Fragment(), EventListener {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: SearchAdapter
    private lateinit var interactor: EventsInteractor

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        interactor = EventsInteractor(EventsRepoImpl())

        adapter = SearchAdapter(this)
        binding.rvSearchEvents.adapter = adapter

        val list = interactor.searchEvents("Cup")

        adapter.submit(list)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun showDetails() {
        findNavController().navigate(R.id.action_searchFragment_to_eventInfoFragment4)
    }
}