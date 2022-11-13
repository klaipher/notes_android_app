package com.example.project.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project.R
import com.example.project.data.Note

class ListAdapter(private val noteList:List<Note>, private val noteClickListener: NoteClickListener):RecyclerView.Adapter<ListAdapter.MyViewHolder>(){

    inner class MyViewHolder(itemView :View) : RecyclerView.ViewHolder(itemView){
        val title2: TextView = itemView.findViewById<TextView>(R.id.txt_title)
        val description2: TextView = itemView.findViewById<TextView>(R.id.txt_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentList = noteList[position]
        holder.title2.text = currentList.title
        holder.description2.text = currentList.description

        holder.itemView.setOnClickListener {
            noteClickListener.clickListener(currentList)
        }
    }

    override fun getItemCount(): Int {
        return noteList.size
    }
}