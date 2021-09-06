package com.marslan.notificationchat.room.tables

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class EntityUser(
    @PrimaryKey
    val id : String,
    val firstName: String?,
    val secondName: String?,
    val userName: String,
    val description: String,
    var userImage: String,
    val phoneNumber: String?,
    val eMail: String?,
    val isActive: Boolean,
    val isBlocked: Boolean,
    val lastActiveDate: String,
)
