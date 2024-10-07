package com.example.donezo.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.donezo.data.model.Note

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)    // when there is insert conflict, it will update the old data row with new one
    suspend fun insert(note: Note)

    @Update
    suspend fun update(note:Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("SELECT * FROM notes WHERE id = :id")
    suspend fun getNoteByID(id: Int): Note?

    @Query("SELECT * FROM notes")
    suspend fun getNoteList(): List<Note>?
}