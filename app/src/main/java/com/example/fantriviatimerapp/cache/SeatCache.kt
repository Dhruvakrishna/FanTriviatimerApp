//The SeatCache class stores seat reservations and keeps track of how recently each seat was
// accessed (using linked hashmap ). When you add or update a seat with put(seatId, isReserved),
// it saves the reservation status. When you check a seat with get(seatId), it returns the status
// and moves that seat to the most recently used position. If the cache reaches 100 seats, the least
//recently used one is automatically removed to make room for new entries. This keeps frequently
// used seats in memory while removing older, unused ones.

package com.example.fantriviatimerapp.cache


class SeatCache {
    private val cache = object : LinkedHashMap<String, Boolean>(100, 0.75f, true) {
        override fun removeEldestEntry(eldest: MutableMap.MutableEntry<String, Boolean>?): Boolean {
            return size > 100
        }
    }

    fun put(seatId: String, isReserved: Boolean) {
        cache[seatId] = isReserved
    }

    fun get(seatId: String): Boolean? {
        return cache[seatId]
    }
}