package com.marslan.notificationchat.repo

import com.marslan.notificationchat.room.tables.EntityMessage
import com.marslan.notificationchat.room.ChatDao

class ChatRepository(private val chatDao: ChatDao) {

    suspend fun newMessage(entity: EntityMessage){
        chatDao.newMessage(entity)
    }
    suspend fun removeMessage(entity: EntityMessage){
        chatDao.removeMessage(entity)
    }
    val getMessage = chatDao.getMessage()
}