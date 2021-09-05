package com.marslan.notificationchat.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [EntityNotification::class],version = 1)
abstract class RoomDB : RoomDatabase() {

    abstract fun notificationDao(): RoomDao

    companion object {
        @Volatile
        private var INSTANCE: RoomDB? = null

        fun getDatabase(context: Context): RoomDB {
            val temp = INSTANCE
            if(temp != null){
                return temp
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomDB::class.java,
                    "notification"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
