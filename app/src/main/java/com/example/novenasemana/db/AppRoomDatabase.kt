package com.example.novenasemana.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.novenasemana.db.dao.AutoDao
import com.example.novenasemana.db.entity.AutoEntity

@Database(entities = [AutoEntity::class],version = 1)
abstract class AppRoomDatabase:RoomDatabase(){
    abstract fun autoDao():AutoDao

    companion object{
        @Volatile
        private var INSTANCE:AppRoomDatabase?=null

        fun getDatabase(context: Context):AppRoomDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppRoomDatabase::class.java,
                    "app"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}