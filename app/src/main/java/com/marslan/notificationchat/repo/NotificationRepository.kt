package com.marslan.notificationchat.repo

import com.marslan.notificationchat.room.EntityNotification
import com.marslan.notificationchat.room.RoomDao

class NotificationRepository(private val notificationDao: RoomDao) {

    suspend fun newNotification(entityNotification: EntityNotification){
        notificationDao.newNotification(entityNotification)
    }
    suspend fun removeNotification(entityNotification: EntityNotification){
        notificationDao.removeNotification(entityNotification)
    }
    val getNotification = notificationDao.getNotification()
}