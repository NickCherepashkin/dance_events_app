package com.drozdova.danceevents.di

import com.drozdova.danceevents.data.ApiService
import com.drozdova.danceevents.data.repository.EventsRepoImpl
import com.drozdova.danceevents.domain.repository.EventsRepo
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    abstract fun bindEventsRepository(repositoryImpl: EventsRepoImpl): EventsRepo

    companion object {
        private const val BASE_URL = "http://192.168.100.4:8080"

        @Provides
        fun provideApiService(retrofit: Retrofit) : ApiService{
            return retrofit.create(ApiService::class.java)
        }

        @Provides
        fun provideRetrofitInstance() : Retrofit{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}