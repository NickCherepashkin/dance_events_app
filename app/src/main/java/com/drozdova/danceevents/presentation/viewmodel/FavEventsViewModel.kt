package com.drozdova.danceevents.presentation.viewmodel

import android.database.SQLException
import android.util.Log
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
class FavEventsViewModel @Inject constructor(
    private val interactor: EventsInteractor
) : ViewModel() {

    private val _favEventsList = MutableLiveData<List<EventModel>>()
    val favEventsList : LiveData<List<EventModel>> = _favEventsList

    private val _bundle = MutableLiveData<EventModel?>()
    val bundle: LiveData<EventModel?> = _bundle

    private val _errorMessage = MutableLiveData<Int>()
    val errorMessage : LiveData<Int> = _errorMessage

    private val _visibility = MutableLiveData<Int>()
    val visibility: LiveData<Int> = _visibility

    fun showFavEventsList() {
        viewModelScope.launch {
            try {
                when(interactor.getFavEventsList()) {
                    ResultCodes.RESULT_SERVER_CONNECT_ERROR ->
                        _errorMessage.value = R.string.error_server_working
                    ResultCodes.RESULT_SQL_ERROR ->
                        _errorMessage.value = R.string.error_database_working
                }
                val favesList = interactor.showFavEventsList()
                favesList.collect{
                    _favEventsList.value = it
                    Log.w("sssssss", _favEventsList.value.toString())
                    showNotFavEventsMessage()
                }

            } catch (error: Exception) {
                _errorMessage.value = R.string.error_show_fav
            }
        }
    }

    fun showFavEventInfo(event: EventModel) {
        _bundle.value = event
    }

    fun deleteFavEvent(idEvent: Int) {
        viewModelScope.launch {
            try {
                interactor.onFavDeleteClicked(idEvent)
            } catch (error:SQLException) {
                _errorMessage.value = R.string.error_database_working
            } catch (error: SocketTimeoutException) {
                _errorMessage.value = R.string.error_server_working
            } catch (error: Exception) {
                _errorMessage.value = R.string.error_del_fav
            }
        }
    }

    fun showNotFavEventsMessage() {
        if(_favEventsList.value != emptyList<EventModel>()) {
            _visibility.value = View.GONE
        } else {
            _visibility.value = View.VISIBLE
        }
    }

    fun onBack(){
        _bundle.value = null
        _favEventsList.apply { value = emptyList() }
    }
}