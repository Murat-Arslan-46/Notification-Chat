package com.marslan.notificationchat.room.tables

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Chat")
data class EntityChat(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val image: String,
    var isMute: Boolean,
    val createDate:String,
    val creatorID: String,
    var isAdmin: Boolean,
    var isWritable: Boolean
)
