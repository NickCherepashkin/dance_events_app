package com.drozdova.danceevents.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.drozdova.danceevents.data.CalendarRepoImpl
import com.drozdova.danceevents.domain.interactor.CalendarInteractor

class CalendarViewModel : ViewModel() {
    private val interactor = CalendarInteractor(CalendarRepoImpl())

    private val _listOfYears = MutableLiveData<List<Int>>()
    val listOfYears : LiveData<List<Int>> = _listOfYears

    fun getListOfYears() {
        _listOfYears.value = interactor.getListOfYears()
    }
}