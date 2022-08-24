package com.leetcode.koko

import kotlin.math.ceil

class KokoEatingBananas {
    fun minEatingSpeed(piles: IntArray, h: Int) = (1..piles.max()).search {
        timeToEatAll(piles, it) <= h
    }
    private fun timeToEatAll(piles: IntArray, k: Int) = piles.sumOf { pile -> timeToEat(pile, k) }

    private fun timeToEat(pile: Int, k: Int) = ceil(pile.toDouble()/k)
}

fun IntRange.search(predicate: (Int) -> Boolean) : Int {
    var left = this.first
    var right = this.last

    while(left < right) {
        val mid = (left + right) / 2

        if(!predicate(mid)) {
            left = mid + 1
        } else {
            right = mid
        }
    }
    return right
}

fun main() {
    val solution = KokoEatingBananas()

    println(solution.minEatingSpeed(intArrayOf(3,6,7,11), 8))
    println(solution.minEatingSpeed(intArrayOf(30,11,23,4,20), 5))
    println(solution.minEatingSpeed(intArrayOf(30,11,23,4,20), 6))
}