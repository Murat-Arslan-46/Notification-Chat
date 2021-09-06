package com.marslan.notificationchat.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.marslan.notificationchat.viewmodel.MainViewModel
import com.marslan.notificationchat.adapter.ChatAdapter
import com.marslan.notificationchat.databinding.ActivityChatBinding

class ChatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        val adapter = ChatAdapter()
        binding.chatList.adapter = adapter
        viewModel.getNotification().observe(this,{
            adapter.setSubmitList(it)
        })
    }
}