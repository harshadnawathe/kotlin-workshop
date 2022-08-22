package com.ledgerco.lending.domain

class LoanAccount(
    val bankName: String,
    val customerName: String,
    val loan: Loan
) {
    private val payments = ArrayList<Payment>()
    fun amountPaid(monthNo: Int): Int {
        val paidThroughEmi = monthNo * loan.emi()
        val paidThroughLumpSum = payments.filter { it.paidAfterMonthNo < monthNo }
            .sumOf(Payment::amount)

//        var paidThroughLumpSum = 0
//        for (payment in payments) {
//            if(payment.paidAfterMonthNo < monthNo) {
//                paidThroughLumpSum += payment.amount
//            }
//        }

        return paidThroughEmi + paidThroughLumpSum
    }
    fun amountRemaining(monthNo: Int) = loan.totalAmount() - amountPaid(monthNo)
    fun balance(monthNo: Int) = Balance(
        bankName = bankName,
        customerName = customerName,
        amountPaid = amountPaid(monthNo),
        numEmiRemaining = loan.numberOfEmi(amountRemaining(monthNo))
    )
    fun addLumpSum(payment: Payment) {
        payments.add(payment)
    }
}