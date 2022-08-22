package com.ledgerco.lending.domain

class LoanAccount(
    val bankName: String,
    val customerName: String,
    val loan: Loan
) {
    fun amountPaid(monthNo: Int) = monthNo * loan.emi()
    fun amountRemaining(monthNo: Int) = loan.totalAmount() - amountPaid(monthNo)
    fun balance(monthNo: Int) = Balance(
        bankName = bankName,
        customerName = customerName,
        amountPaid = amountPaid(monthNo),
        numEmiRemaining = loan.numberOfEmi(amountRemaining(monthNo))
    )
}