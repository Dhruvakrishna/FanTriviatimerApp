
//The fetchTickets() function fetches data from the API without blocking the main thread.
//try catch block to handle exceptions
package com.example.fantriviatimerapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.example.fantriviatimerapp.data.TicketRepository

class TicketViewModel(private val repository: TicketRepository) : ViewModel() {

    private val _tickets = MutableStateFlow<List<String>>(emptyList())
    val tickets: StateFlow<List<String>> = _tickets

    fun fetchTickets() {
        viewModelScope.launch {
            try {
                val result = repository.loadTickets()
                _tickets.value = result
            } catch (e: Exception) {
            }
        }
    }
}