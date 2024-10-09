package com.example.donezo.ui.activities.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.donezo.data.model.Note
import com.example.donezo.repository.NoteRepository
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainActivityViewModel(private val repo: NoteRepository) : ViewModel() {

    // Live Data to notify when to navigate
    private val _navigateToEditTaskActivity = MutableLiveData<Boolean>()
    val navigateToEditTaskActivity : LiveData<Boolean> get() = _navigateToEditTaskActivity

    fun onCreateTaskButtonClick(){
        // Dispatching on Main UI Thread
        viewModelScope.launch(Dispatchers.Main){
            //delay(500)
            _navigateToEditTaskActivity.value = true
        }
    }

    suspend fun onLoadData(): List<Note>? {
        val data = viewModelScope.async(Dispatchers.IO){repo.getNoteList()}
        return data.await()
    }

}