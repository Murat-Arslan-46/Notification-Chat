package com.marslan.notificationchat.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notificationTable")
data class EntityNotification(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val body: String,
    val title: String?,
    val data: String?
)
