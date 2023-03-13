package com.drozdova.danceevents.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.drozdova.danceevents.R
import com.drozdova.danceevents.domain.interactor.EventsInteractor
import com.drozdova.danceevents.presentation.model.EventDateModel
import com.drozdova.danceevents.utils.ResultCodes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CalendarViewModel @Inject constructor(
    private val interactor: EventsInteractor
) : ViewModel() {
    private val _listOfEventsDates = MutableLiveData<List<EventDateModel>>()
    val listOfEventsDates : LiveData<List<EventDateModel>> = _listOfEventsDates

    private val _errorMessage = MutableLiveData<Int>()
    val errorMessage : LiveData<Int> = _errorMessage

    fun getEventsList() {
        viewModelScope.launch {
            try {
                when(interactor.getEventsList()) {
                    ResultCodes.RESULT_SERVER_CONNECT_ERROR ->
                        _errorMessage.value = R.string.error_server_working
                    ResultCodes.RESULT_SQL_ERROR ->
                        _errorMessage.value = R.string.error_database_working
                }
                Log.w("error", "error 1")
                _listOfEventsDates.value = interactor.getSelectedDatesList()
            } catch (error: Exception) {
                Log.w("error", error)
                _errorMessage.value = R.string.error_geting_list_ev_dates
            }
        }
    }
}