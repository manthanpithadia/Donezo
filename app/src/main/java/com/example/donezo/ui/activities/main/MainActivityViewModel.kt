package com.example.donezo.ui.activities.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {

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
}