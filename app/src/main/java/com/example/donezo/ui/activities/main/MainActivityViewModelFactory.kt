package com.example.donezo.ui.activities.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.donezo.repository.NoteRepository

class MainActivityViewModelFactory(val repo: NoteRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainActivityViewModel::class.java)){
            return MainActivityViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown Main Activity View Model")
    }
}