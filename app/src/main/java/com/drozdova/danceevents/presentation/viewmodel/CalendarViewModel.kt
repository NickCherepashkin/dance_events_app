package com.drozdova.danceevents.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.drozdova.danceevents.data.CalendarRepoImpl
import com.drozdova.danceevents.domain.interactor.CalendarInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CalendarViewModel @Inject constructor(
    private val interactor: CalendarInteractor
) : ViewModel() {

    private val _listOfYears = MutableLiveData<List<Int>>()
    val listOfYears : LiveData<List<Int>> = _listOfYears

    fun getListOfYears() {
        _listOfYears.value = interactor.getListOfYears()
    }
}