package com.drozdova.danceevents.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.drozdova.danceevents.domain.interactor.EventsInteractor
import com.drozdova.danceevents.presentation.model.EventDateModel
import com.drozdova.danceevents.presentation.model.EventModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CalendarViewModel @Inject constructor(
    private val interactor: EventsInteractor
) : ViewModel() {
    private val _listOfDates = MutableLiveData<List<EventDateModel>>()
    val listOfDates : LiveData<List<EventDateModel>> = _listOfDates

    fun getEventsList() {
        viewModelScope.launch {
            interactor.getEventsList()
            _listOfDates.value = interactor.getSelectedDatesList()
        }
    }

    fun getSelectedDatesList(){
        viewModelScope.launch {

        }
    }
}