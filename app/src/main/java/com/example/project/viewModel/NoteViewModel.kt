package com.example.project.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.project.data.Note
import com.example.project.data.NoteDatabase
import com.example.project.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    val readAllData: LiveData<List<Note>>

    private val repository: NoteRepository

    init {
        val noteDao = NoteDatabase.getInstance(application).noteDao()
        repository = NoteRepository(noteDao)
        readAllData = repository.readAllData
    }

    fun addNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addNotes(note)
        }
    }

    fun updateNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateNotes(note)
        }
    }

    fun deleteSingleNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteSingleNote(note)
        }
    }

    fun deleteAllNote() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllNotes()
        }
    }



}