package com.example.donezo.ui.activities

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.donezo.data.model.Note
import com.example.donezo.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EditTaskViewModel(private val repository: NoteRepository) : ViewModel() {

    private var _saved = MutableLiveData<Boolean>()
    val saved: LiveData<Boolean> = _saved

    fun isSavedClicked(note: Note){
        // I am saving my data into my Room DB here, therefore I am dispatching my coroutine on IO thread
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.insert(note)    // Getting task in IO thread

            // using withContext to perform n number of operations on different thread while I am in IO thread,
            // this will help me perform the operation without creating a new function for this Dispatcher
            // and it will not block my current IO thread.
            withContext(Dispatchers.Main){
                // Updating UI in Main Thread
                _saved.value = true
            }
        }

    }
}