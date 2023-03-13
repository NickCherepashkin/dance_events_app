package com.drozdova.danceevents.presentation.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.drozdova.danceevents.R
import com.drozdova.danceevents.domain.interactor.EventsInteractor
import com.drozdova.danceevents.presentation.model.EventDateModel
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

    private val _date = MutableLiveData<EventDateModel>()
    val date: LiveData<EventDateModel> = _date

    private val _visibility = MutableLiveData<Int>()
    val visibility: LiveData<Int> = _visibility

    private val _errorMessage = MutableLiveData<Int>()
    val errorMessage : LiveData<Int> = _errorMessage


    private fun showEventsInMonth(dateStart: String, dateEnd: String) {
        viewModelScope.launch {
            try {
                _eventsListInMonth.value = interactor.getEventsInMonth(dateStart, dateEnd)
                setVisibility()
            } catch (error: Exception) {
                _errorMessage.value = R.string.error_get_list_events
            }
        }
    }

    fun showEventInfo(event: EventModel) {
        _bundle.value = event
    }

    fun onBack(){
        _bundle.value = null
        _eventsListInMonth.apply { value = emptyList() }
    }

    fun setMonth(month: Int, year: Int){
        val dateStart = "01.${month + 1}.${year}"
        val dateEnd = "31.${month + 1}.${year}"
        _date.value = EventDateModel(1, month, year)
        showEventsInMonth(dateStart, dateEnd)
    }

    private fun setVisibility() {
        if (_eventsListInMonth.value != emptyList<EventModel>()) {
            _visibility.value = View.GONE
        } else {
            _visibility.value = View.VISIBLE
        }
    }
}