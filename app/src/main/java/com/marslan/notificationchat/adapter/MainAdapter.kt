package com.marslan.notificationchat.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marslan.notificationchat.databinding.ItemMessageBinding
import com.marslan.notificationchat.room.EntityNotification
import org.json.JSONObject

class MainAdapter():RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object{
        private var submitList: List<EntityNotification> = listOf()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMessageBinding.inflate(inflater,parent,false)
        return MessageViewHolder(binding)
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MessageViewHolder).bind(position)
    }
    override fun getItemCount() = submitList.size
    @SuppressLint("NotifyDataSetChanged")
    fun setSubmitList(list: List<EntityNotification>){
        submitList = list
        notifyDataSetChanged()
    }

    inner class MessageViewHolder(private val binding: ItemMessageBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(position: Int){
            val message = submitList[position]
            binding.messageText.text = message.body
        }
    }
}