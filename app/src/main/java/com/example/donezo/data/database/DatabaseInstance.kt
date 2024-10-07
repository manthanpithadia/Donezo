package com.example.donezo.data.database

import android.content.Context
import androidx.room.Room

object DatabaseInstance {

    @Volatile   // this @Volatile ensures that once INSTANCE variable is updated it notifies to all the threads
    private var INSTANCE: NoteDatabase? = null

    fun getDatabase(context: Context): NoteDatabase {
        // Synchronized ensures that only 1 thread can enter into that block,
        // this represents lock value, so ex: if thread 1 is executing block
        // then thread 2 can not enter until thread 1 is not completed
        return INSTANCE ?: synchronized(lock = this) {
            val instance =
                Room.databaseBuilder(context.applicationContext, NoteDatabase::class.java, "NoteDB")
                    .build()
            INSTANCE = instance
            instance // return value
        }
    }
}