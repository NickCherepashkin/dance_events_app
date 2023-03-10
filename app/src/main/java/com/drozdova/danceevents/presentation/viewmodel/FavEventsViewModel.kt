package com.drozdova.danceevents.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.drozdova.danceevents.domain.interactor.EventsInteractor
import com.drozdova.danceevents.presentation.model.EventModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavEventsViewModel @Inject constructor(
    private val interactor: EventsInteractor
) : ViewModel() {

    private val _favEventsList = MutableLiveData<List<EventModel>>()
    val favEventsList : LiveData<List<EventModel>> = _favEventsList

    private val _bundle = MutableLiveData<EventModel?>()
    val bundle: LiveData<EventModel?> = _bundle

    fun showFavEventsList() {
        viewModelScope.launch {
            interactor.getFavEventsList()
            val favesList = interactor.showFavEventsList()
            favesList.collect{
                _favEventsList.value = it
            }
        }
    }

    fun showFavEventInfo(event: EventModel) {
        _bundle.value = event
    }

    fun deleteFavEvent(idEvent: Int) {
        viewModelScope.launch {
            interactor.onFavDeleteClicked(idEvent)
        }
    }

    fun onBack(){
        _bundle.value = null
        _favEventsList.apply { value = emptyList() }
    }
}