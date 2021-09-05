package com.marslan.notificationchat

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.marslan.notificationchat.repo.NotificationRepository
import com.marslan.notificationchat.room.EntityNotification
import com.marslan.notificationchat.room.RoomDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application) {
    private val repository: NotificationRepository

    init {
        val dao = RoomDB.getDatabase(application).notificationDao()
        repository = NotificationRepository(dao)
    }

    fun newNotification(entityNotification: EntityNotification){
        viewModelScope.launch(Dispatchers.IO) {
            repository.newNotification(entityNotification)
        }
    }
    fun removeNotification(entityNotification: EntityNotification){
        viewModelScope.launch(Dispatchers.IO) {
            repository.removeNotification(entityNotification)
        }
    }
    fun getNotification() = repository.getNotification
}