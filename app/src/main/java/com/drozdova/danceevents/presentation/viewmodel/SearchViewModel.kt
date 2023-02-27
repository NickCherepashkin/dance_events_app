package com.drozdova.danceevents.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.drozdova.danceevents.data.EventsRepoImpl
import com.drozdova.danceevents.domain.interactor.EventsInteractor
import com.drozdova.danceevents.presentation.model.EventModel

class SearchViewModel : ViewModel() {
    private val interactor = EventsInteractor(EventsRepoImpl())

    private val _searchList = MutableLiveData<List<EventModel>>()
    val searchList : LiveData<List<EventModel>> = _searchList

    private val _bundle = MutableLiveData<EventModel?>()
    val bundle: LiveData<EventModel?> = _bundle

    fun searchEventsList(title: String) {
        _searchList.value = interactor.searchEvents(title)
    }

    fun showEventInfo(event: EventModel) {
        _bundle.value = event
    }

    fun onBack(){
        _bundle.value = null
        _searchList.apply { null }
    }
}