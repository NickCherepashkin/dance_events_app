package com.drozdova.danceevents.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.drozdova.danceevents.data.database.bean.EventEntity
import com.drozdova.danceevents.data.database.bean.FavEntity
import com.drozdova.danceevents.data.database.dao.EventsDAO
import com.drozdova.danceevents.data.database.dao.FavesDAO


@Database(entities = [EventEntity::class, FavEntity::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase(){
    abstract fun getEventsDAO(): EventsDAO
    abstract fun getFavesDAO(): FavesDAO

    companion object {
        private var DB_INSTANCE: AppDataBase? = null

        fun getItemsDataBaseInstance(context: Context) : AppDataBase {
            return DB_INSTANCE ?: Room
                .databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "DE_DB"
                )
                .build()
                .also { DB_INSTANCE = it }
        }
    }
}