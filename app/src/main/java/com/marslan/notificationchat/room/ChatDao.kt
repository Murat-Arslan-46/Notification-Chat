package com.marslan.notificationchat.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.marslan.notificationchat.room.tables.EntityMessage
import com.marslan.notificationchat.room.tables.EntityUser

@Dao
interface ChatDao {

    @Insert(entity = EntityUser::class)
    suspend fun newUser(entity: EntityUser)
    @Delete(entity = EntityUser::class)
    suspend fun removeUser(entity: EntityUser)
    @Query("select * from User")
    fun getUser(): LiveData<List<EntityUser>>

    @Insert(entity = EntityMessage::class)
    suspend fun newMessage(entity: EntityMessage)
    @Delete(entity = EntityMessage::class)
    suspend fun removeMessage(entity: EntityMessage)
    @Query("select * from Message")
    fun getMessage(): LiveData<List<EntityMessage>>

}