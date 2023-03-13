package com.drozdova.danceevents.presentation.viewmodel

import android.database.SQLException
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.drozdova.danceevents.R
import com.drozdova.danceevents.domain.interactor.EventsInteractor
import com.drozdova.danceevents.presentation.model.EventModel
import com.drozdova.danceevents.utils.ResultCodes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException
import javax.inject.Inject

@HiltViewModel
class EventsViewModel @Inject constructor(
    private val interactor: EventsInteractor
) : ViewModel() {

    private val _eventsList = MutableLiveData<List<EventModel>>()
    val eventsList : LiveData<List<EventModel>> = _eventsList

    private val _bundle = MutableLiveData<EventModel?>()
    val bundle: LiveData<EventModel?> = _bundle

    private val _errorMessage = MutableLiveData<Int>()
    val errorMessage : LiveData<Int> = _errorMessage

    private val _visibility = MutableLiveData<Int>()
    val visibility: LiveData<Int> = _visibility

    fun showEventsList() {
        viewModelScope.launch {
            try {
                when(interactor.getEventsList()) {
                    ResultCodes.RESULT_SERVER_CONNECT_ERROR ->
                        _errorMessage.value = R.string.error_server_working
                    ResultCodes.RESULT_SQL_ERROR ->
                        _errorMessage.value = R.string.error_database_working
                }
                _eventsList.value = interactor.showEventsList()
                showNotEventsMessage()
            } catch (error: Exception) {
                _errorMessage.value = R.string.error_get_list_events
            }
        }
    }

    fun onFavClicked(id: Int, isFavorite: Boolean) {
        viewModelScope.launch {
            try {
                interactor.onFavClicked(id, isFavorite)
            } catch (error:SQLException) {
                _errorMessage.value = R.string.error_database_working
            } catch (error: SocketTimeoutException) {
                _errorMessage.value = R.string.error_server_working
            } catch (error: Exception) {
                _errorMessage.value = R.string.error_add_fav
            }
        }
    }

    fun showEventInfo(event: EventModel) {
        _bundle.value = event
    }

    fun onBack(){
        _bundle.value = null
        _eventsList.apply { value = emptyList() }
    }

    fun showNotEventsMessage() {
        if(_eventsList.value != emptyList<EventModel>()) {
            _visibility.value = View.GONE
        } else {
            _visibility.value = View.VISIBLE
        }
    }
}