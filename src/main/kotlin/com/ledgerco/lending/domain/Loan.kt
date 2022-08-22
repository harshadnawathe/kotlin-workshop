package com.ledgerco.lending.domain

class Loan(
    val principleAmount: Int,
    val periodInYears: Int,
    val rateOfInterest: Int
) {
    fun interest() = (principleAmount * periodInYears * rateOfInterest) / 100.0
}
