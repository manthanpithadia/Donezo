package com.example.donezo.repository

import androidx.lifecycle.LiveData
import com.example.donezo.data.NoteDao
import com.example.donezo.data.model.Note

// This is to call functions, because I can't call them using Interface,
// so I have to create a class to call the functions

class NoteRepository(private val dao: NoteDao){
    suspend fun insert(note: Note) {
        dao.insert(note)
    }

    suspend fun update(note: Note) {
        dao.update(note)
    }

    suspend fun delete(note: Note) {
        dao.delete(note)
    }

    suspend fun getNoteByID(id: Int): Note? {
        return dao.getNoteByID(id)
    }

    suspend fun getNoteList(): List<Note>? {
        return dao.getNoteList()
    }
}