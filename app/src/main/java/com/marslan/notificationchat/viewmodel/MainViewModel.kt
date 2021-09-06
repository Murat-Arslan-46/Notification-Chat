package com.marslan.notificationchat.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.marslan.notificationchat.repo.ChatRepository
import com.marslan.notificationchat.room.ChatDB
import com.marslan.notificationchat.room.tables.EntityMessage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application) {
    private val repository: ChatRepository

    init {
        val dao = ChatDB.getDatabase(application).chatDao()
        repository = ChatRepository(dao)
    }

    fun newMessage(entity: EntityMessage){
        viewModelScope.launch(Dispatchers.IO) {
            repository.newMessage(entity)
        }
    }
    fun removeMessage(entity: EntityMessage){
        viewModelScope.launch(Dispatchers.IO) {
            repository.removeMessage(entity)
        }
    }
    fun getMessage() = repository.getMessage
}