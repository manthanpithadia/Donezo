package com.example.donezo.data.model

data class Note(
    val title: String,
    val desc: String,
    val date: String,
    val color: Int,
    val isFavourite: Boolean,
    val isCompleted: Boolean
)
