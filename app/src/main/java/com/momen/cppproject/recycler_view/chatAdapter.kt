package com.momen.cppproject.recycler_view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.momen.cppproject.R
import kotlinx.android.synthetic.main.chat_row_item.view.*
import kotlinx.android.synthetic.main.fragment_gallery.*
import model.dataChat
import java.util.ArrayList

class chatAdapter(val messageList : ArrayList<dataChat>) : RecyclerView.Adapter<chatAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.chat_row_item , parent,false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data : dataChat = messageList[position]
        holder.txt_email.text = data.email
        holder.txt_message.text = data.message
    }
    override fun getItemCount(): Int {
        return messageList.size
    }
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val txt_message = itemView.txtMessage as TextView
        val txt_email = itemView.txtEmail as TextView
    }
}
