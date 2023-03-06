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
class MonthWithEventsViewModel @Inject constructor(
    private val interactor: EventsInteractor
) : ViewModel() {

    private val _eventsListInMonth = MutableLiveData<List<EventModel>>()
    val eventsListInMonth : LiveData<List<EventModel>> = _eventsListInMonth

    private val _bundle = MutableLiveData<EventModel?>()
    val bundle: LiveData<EventModel?> = _bundle

    fun showEventsInMonth(dateStart: String, dateEnd: String) {
        viewModelScope.launch {
            _eventsListInMonth.value = interactor.getEventsInMonth(dateStart, dateEnd)
        }
    }

    fun showEventInfo(event: EventModel) {
        _bundle.value = event
    }

    fun onBack(){
        _bundle.value = null
        _eventsListInMonth.apply { null }
    }
}