package com.marslan.notificationchat.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.marslan.notificationchat.room.tables.EntityMessage
import com.marslan.notificationchat.room.tables.EntityUser

@Database(entities = [EntityMessage::class, EntityUser::class],version = 1)
abstract class ChatDB : RoomDatabase() {

    abstract fun chatDao(): ChatDao

    companion object {
        @Volatile
        private var INSTANCE: ChatDB? = null

        fun getDatabase(context: Context): ChatDB {
            val temp = INSTANCE
            if(temp != null){
                return temp
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ChatDB::class.java,
                    "chat.db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
