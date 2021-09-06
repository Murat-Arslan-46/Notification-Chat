package com.marslan.notificationchat.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.marslan.notificationchat.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener { startChatActivity() }
    }

    fun startChatActivity(){
        val activity = Intent(this,ChatActivity::class.java)
        startActivity(activity)
    }
}