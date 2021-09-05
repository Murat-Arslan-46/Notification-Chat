package com.marslan.notificationchat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.marslan.notificationchat.adapter.MainAdapter
import com.marslan.notificationchat.databinding.ActivityMainBinding
import com.onesignal.OneSignal

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        val adapter = MainAdapter()
        binding.mainList.adapter = adapter
        viewModel.getNotification().observe(this,{
            adapter.setSubmitList(it)
        })

    }
}