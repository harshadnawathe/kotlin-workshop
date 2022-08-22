package com.ledgerco.lending.domain

class LoanAccount(
    val bankName: String,
    val customerName: String,
    val loan: Loan
) {
    fun amountPaid(monthNo: Int) = monthNo * loan.emi()
}