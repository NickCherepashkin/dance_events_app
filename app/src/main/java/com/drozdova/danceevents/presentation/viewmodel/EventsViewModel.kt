package com.drozdova.danceevents.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.drozdova.danceevents.data.EventsRepoImpl
import com.drozdova.danceevents.domain.interactor.EventsInteractor
import com.drozdova.danceevents.presentation.model.EventModel

class EventsViewModel : ViewModel() {
    private val interactor = EventsInteractor(EventsRepoImpl())

    private val _eventsList = MutableLiveData<List<EventModel>>()
    val eventsList : LiveData<List<EventModel>> = _eventsList

    private val _bundle = MutableLiveData<EventModel?>()
    val bundle: LiveData<EventModel?> = _bundle

    fun showEventsList() {
        _eventsList.value = interactor.getEventsList()
    }

    fun showEventInfo(event: EventModel) {
        _bundle.value = event
    }

    fun onBack(){
        _bundle.value = null
        eventsList.apply { null }
    }
}