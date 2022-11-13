package com.example.project.adapter

import com.example.project.data.Note

interface NoteClickListener {
    fun clickListener(position: Note)
}