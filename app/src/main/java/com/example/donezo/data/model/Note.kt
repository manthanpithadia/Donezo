package com.example.donezo.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val color: Int,
    val date: String,
    val title: String,
    val content: String,
    val isFavorite: Boolean,
)
