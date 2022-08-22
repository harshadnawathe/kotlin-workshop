package com.ledgerco.lending.domain

class Balance(
    val bankName: String,
    val customerName: String,
    val amountPaid: Int,
    val numEmiRemaining: Int
)