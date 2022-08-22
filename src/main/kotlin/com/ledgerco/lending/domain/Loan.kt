package com.ledgerco.lending.domain

import kotlin.math.ceil

class Loan(
    val principleAmount: Int,
    val periodInYears: Int,
    val rateOfInterest: Int
) {
    fun interest() = (principleAmount * periodInYears * rateOfInterest) / 100.0
    fun totalAmount() = principleAmount + interest()
    fun emi() = ceil(totalAmount() / (periodInYears * 12)).toInt()
    fun numberOfEmi(amountRemaining: Double) = if (amountRemaining > 0) {
        ceil(amountRemaining / emi()).toInt()
    } else {
        0
    }
}
