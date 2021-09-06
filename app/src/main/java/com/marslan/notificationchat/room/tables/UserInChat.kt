package com.marslan.notificationchat.room.tables

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserInChat(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val userID: String,
    val chatID: Int,
)
