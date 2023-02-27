package com.drozdova.danceevents.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.drozdova.danceevents.data.EventsRepoImpl
import com.drozdova.danceevents.domain.interactor.EventsInteractor
import com.drozdova.danceevents.presentation.model.EventModel

class FavEventsViewModel : ViewModel() {
    private val interactor = EventsInteractor(EventsRepoImpl())

    private val _favEventsList = MutableLiveData<List<EventModel>>()
    val favEventsList : LiveData<List<EventModel>> = _favEventsList

    private val _bundle = MutableLiveData<EventModel?>()
    val bundle: LiveData<EventModel?> = _bundle

    fun showFavEventsList() {
        _favEventsList.value = interactor.getFavEventsList()
    }

    fun showFavEventInfo(event: EventModel) {
        _bundle.value = event
    }

    fun onBack(){
        _bundle.value = null
        _favEventsList.apply { null }
    }
}