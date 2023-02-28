package com.drozdova.danceevents.di

import com.drozdova.danceevents.data.CalendarRepoImpl
import com.drozdova.danceevents.data.EventsRepoImpl
import com.drozdova.danceevents.domain.repository.CalendarRepo
import com.drozdova.danceevents.domain.repository.EventsRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    abstract fun bindCalendarRepository(repositoryImpl: CalendarRepoImpl): CalendarRepo
 
    @Binds
    abstract fun bindEventsRepository(repositoryImpl: EventsRepoImpl): EventsRepo
}