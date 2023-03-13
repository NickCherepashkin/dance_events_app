package com.drozdova.danceevents.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.drozdova.danceevents.R
import com.drozdova.danceevents.domain.interactor.EventsInteractor
import com.drozdova.danceevents.presentation.model.EventModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val interactor: EventsInteractor
) : ViewModel() {

    private val _searchList = MutableLiveData<List<EventModel>>()
    val searchList : LiveData<List<EventModel>> = _searchList

    private val _bundle = MutableLiveData<EventModel?>()
    val bundle: LiveData<EventModel?> = _bundle

    private val _errorMessage = MutableLiveData<Int>()
    val errorMessage : LiveData<Int> = _errorMessage

    fun searchEventsList(title: String) {
        viewModelScope.launch {
            try {
                _searchList.value = interactor.searchEvents(title)
            } catch (error: Exception) {
                _errorMessage.value = R.string.error_search
            }

        }
    }

    fun showEventInfo(event: EventModel) {
        _bundle.value = event
    }

    fun onBack(){
        _bundle.value = null
        _searchList.apply { value = emptyList() }
    }
}