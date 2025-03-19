package com.example.fantriviatimerapp

import com.example.fantriviatimerapp.cache.SeatCache
import org.junit.Assert.assertEquals
import org.junit.Test

class SeatCacheTest {

    @Test
    fun testSeatReservation() {
        val seatCache = SeatCache()
        seatCache.put("A1", true)
        seatCache.put("A2", false)

        // Check results:
        assertEquals(true, seatCache.get("A1"))
        assertEquals(false, seatCache.get("A2"))
        assertEquals(null, seatCache.get("A3"))  // This should return null, since not set
    }
}