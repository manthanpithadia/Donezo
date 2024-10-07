package com.example.donezo.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.donezo.data.NoteDao
import com.example.donezo.data.model.Note

/*
* The version specifies the version of the database schema.
* The version starts at 1 and is incremented every time you
* make schema changes (e.g., adding a new table, changing a column, etc.).
Since this is the first version of the database schema, it's set to 1.
* */

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun noteDao(): NoteDao
}