//The function finds the time for 24 hours ago and keeps only the notifications that are newer
// than that. I use Kotlin's filter function to check each notification’s timestamp greater than or
// equal to this threshold.
package com.example.fantriviatimerapp.extensions


data class Notification(val timestamp: Long)

fun List<Notification>.filterRecent(): List<Notification> {

    val cutoff = System.currentTimeMillis() - 24 * 60 * 60 * 1000 // readable in milliseconds

    return this.filter { it.timestamp >= cutoff }

}

