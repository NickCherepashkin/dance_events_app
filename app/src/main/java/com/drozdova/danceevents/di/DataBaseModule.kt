package com.drozdova.danceevents.di

import android.content.Context
import com.drozdova.danceevents.data.database.AppDataBase
import com.drozdova.danceevents.data.database.dao.EventsDAO
import com.drozdova.danceevents.data.database.dao.FavesDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {
    @Provides
    fun providesEventsDAO(appDataBase: AppDataBase): EventsDAO {
        return appDataBase.getEventsDAO()
    }

    @Provides
    fun providesFavesDAO(appDataBase: AppDataBase): FavesDAO {
        return appDataBase.getFavesDAO()
    }

    @Provides
    fun appDataBase(context: Context): AppDataBase {
        return AppDataBase.getItemsDataBaseInstance(context)
    }
}