package com.leetcode.koko

class KokoEatingBananas {

    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        return binarySearch(piles, h)!!
    }

    private fun linearSearch(piles: IntArray, h: Int): Int? {
        for (currSpeed in 1..piles.max()) {
            val time = timeToEatAll(piles, currSpeed)
            if (time == h) {
                return time
            }
        }
        return null
    }

    private fun binarySearch(piles: IntArray, h: Int) : Int? {
        var left = 1
        var right = piles.max()

        while (left < right) {
            val currSpeed = (left + right) / 2

            val time = timeToEatAll(piles, currSpeed)
            if(time == h) {
                return time
            }

            if(time < h) {
                left = currSpeed + 1
            } else {
                right = currSpeed
            }
        }
        return null
    }

    private fun timeToEatAll(piles: IntArray, k: Int): Int {
        var timeToEatAll = 0
        for (pile in piles) {
            var timeToEatCurrentPile = pile / k
            if (pile % k > 0) {
                timeToEatCurrentPile += 1
            }
            timeToEatAll += timeToEatCurrentPile
        }
        return timeToEatAll
    }
}