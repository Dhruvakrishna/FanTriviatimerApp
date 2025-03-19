//TicketRepository handles data fetching, making the function reusable and testable.
//Replaced Thread with Kotlin Coroutines
//Network requests are performed in the background using coroutines

package com.example.fantriviatimerapp.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONArray
import java.net.HttpURLConnection
import java.net.URL

class TicketRepository {
    suspend fun loadTickets(): List<String> = withContext(Dispatchers.IO) {
        val url = URL("https://api.example.com/tickets")
        val connection = url.openConnection() as HttpURLConnection
        val response = connection.inputStream.bufferedReader().readText()
        val jsonArray = JSONArray(response)
        List(jsonArray.length()) { index -> jsonArray.getString(index) }
    }
}

