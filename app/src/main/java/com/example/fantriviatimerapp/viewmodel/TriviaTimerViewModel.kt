
//I am using a countdown timer using StateFlow,UI is able to observe time
// updates. When startTimer is called, it cancels any existing timer and starts a new
// countdown,updating the time every second until it reaches zero. The stopTimer() method can be used to
// stop the timer manually and reset it to zero. The onCleared() function ensures that any
// running timer is canceled when the ViewModel is destroyed, preventing memory leaks.

package com.example.fantriviatimerapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TriviaTimerViewModel : ViewModel() {

    private val _timeLeft = MutableStateFlow(0)
    val timeLeft: StateFlow<Int> = _timeLeft

    private var timerJob: Job? = null

    fun startTimer(duration: Int) {
        timerJob?.cancel()

        // coroutine for the countdown timer
        timerJob = viewModelScope.launch {
            for (time in duration downTo 0) {
                _timeLeft.value = time // Update the timer state
                delay(1000L)
            }
        }
    }

    fun stopTimer() {
        timerJob?.cancel() // Cancel the coroutine job if active
        _timeLeft.value = 0 //
    }

    override fun onCleared() {
        super.onCleared()
        timerJob?.cancel() // Cancel the running timer if any
    }
}


