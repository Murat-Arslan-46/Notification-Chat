package com.marslan.notificationchat.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RoomDao {

    @Insert(entity = EntityNotification::class)
    suspend fun newNotification(entityNotification: EntityNotification)
    @Delete(entity = EntityNotification::class)
    suspend fun removeNotification(entityNotification: EntityNotification)
    @Query("select * from notificationTable")
    fun getNotification(): LiveData<List<EntityNotification>>

}