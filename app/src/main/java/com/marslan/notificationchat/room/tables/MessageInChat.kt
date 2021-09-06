package com.marslan.notificationchat.room.tables

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MessageInChat(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val chatID: Int,
    val messageID: Int,
)
