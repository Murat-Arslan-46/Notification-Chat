package com.marslan.notificationchat.room.tables

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.marslan.notificationchat.enums.ContentType
import com.marslan.notificationchat.enums.MessageStatus

@Entity(tableName = "Message")
data class EntityMessage(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val text: String?,
    val date: String,
    val fromUserID: String,
    val toUser: String,
    var status: MessageStatus,
    val contentType: ContentType,
    val contentSource: String?
)