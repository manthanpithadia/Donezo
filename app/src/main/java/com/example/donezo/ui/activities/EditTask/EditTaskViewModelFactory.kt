package com.example.donezo.ui.activities.EditTask

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.donezo.repository.NoteRepository

@Suppress("UNCHECKED_CAST")
class EditTaskViewModelFactory(private val repository: NoteRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(EditTaskViewModel::class.java)){
            return EditTaskViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown Edit Task View Model Class")
    }
}