package com.leetcode.koko

class KokoEatingBananas {

    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        return binarySearch(piles, h)!!
    }

    private fun linearSearch(piles: IntArray, h: Int): Int? {
        for (currSpeed in 1..piles.max()) {
            val time = timeToEatAll(piles, currSpeed)
            if (time == h) {
                return currSpeed
            }
        }
        return null
    }

    private fun binarySearch(piles: IntArray, h: Int) : Int {
        var left = 1
        var right = piles.max()

        while (left < right) {
            val currSpeed = (left + right) / 2

            val time = timeToEatAll(piles, currSpeed)
            if(time <= h) {
                right = currSpeed
            } else {
                left = currSpeed + 1
            }
        }
        return right
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

fun main() {
    val solution = KokoEatingBananas()

    println(solution.minEatingSpeed(intArrayOf(3,6,7,11), 8))
    println(solution.minEatingSpeed(intArrayOf(30,11,23,4,20), 5))
    println(solution.minEatingSpeed(intArrayOf(30,11,23,4,20), 6))
}