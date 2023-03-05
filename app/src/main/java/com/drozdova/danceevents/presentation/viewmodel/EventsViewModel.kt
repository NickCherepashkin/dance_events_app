package com.drozdova.danceevents.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.drozdova.danceevents.data.repository.EventsRepoImpl
import com.drozdova.danceevents.domain.interactor.EventsInteractor
import com.drozdova.danceevents.presentation.model.EventModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventsViewModel @Inject constructor(
    private val interactor: EventsInteractor
) : ViewModel() {

    private val _eventsList = MutableLiveData<List<EventModel>>()
    val eventsList : LiveData<List<EventModel>> = _eventsList

    private val _bundle = MutableLiveData<EventModel?>()
    val bundle: LiveData<EventModel?> = _bundle

    fun showEventsList() {
        viewModelScope.launch {
            interactor.getEventsList()
            _eventsList.value = interactor.showEventsList()
        }

    }

    fun showEventInfo(event: EventModel) {
        _bundle.value = event
    }

    fun onBack(){
        _bundle.value = null
        eventsList.apply { null }
    }
}