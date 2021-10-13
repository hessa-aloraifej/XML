package com.example.xml

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*

class StudentsRVAdapter (private val students: ArrayList<Students>): RecyclerView.Adapter<StudentsRVAdapter.VideoViewHolder>(){
    class VideoViewHolder(item_row: View): RecyclerView.ViewHolder(item_row){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_row,
            parent,
            false
        )
        return VideoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val student=students[position]
        holder.itemView.apply{
            tvid.text= student.id.toString()
            tvname.text=student.name
            tvmark.text=student.marks.toString()
        }
    }

    override fun getItemCount() = students.size
}