package com.example.project.repository

import androidx.lifecycle.LiveData
import com.example.project.data.Note
import com.example.project.data.NoteDao

class NoteRepository(private val noteDao: NoteDao) {

    val readAllData: LiveData<List<Note>> = noteDao.readNotes()

    suspend fun addNotes(notes: Note) {
        noteDao.addNote(notes)
    }

    suspend fun updateNotes(notes: Note) {
        noteDao.updateNote(notes)
    }

    suspend fun deleteSingleNote(notes: Note){
        noteDao.deleteSingleNote(notes)
    }

    suspend fun deleteAllNotes(){
        noteDao.deleteAllNote()
    }
}
