package com.example.donezo

import android.app.Activity
import android.content.Context
import android.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import com.example.donezo.data.NoteDao
import com.example.donezo.data.database.DatabaseInstance
import com.example.donezo.repository.NoteRepository
import com.google.accompanist.systemuicontroller.rememberSystemUiController

// Extension function for Activity to change the status bar color
@Composable
fun Activity.setStatusBarColor(color: androidx.compose.ui.graphics.Color, darkIcons: Boolean = false) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(
            color = color,
            darkIcons = darkIcons // Set to true if you want dark icons, false for light icons
        )
    }
}

fun Activity.getNoteRepository():NoteRepository{
    val database = DatabaseInstance.getDatabase(this)
    val dao = database.noteDao()
    val repo = NoteRepository(dao)
    return repo
}