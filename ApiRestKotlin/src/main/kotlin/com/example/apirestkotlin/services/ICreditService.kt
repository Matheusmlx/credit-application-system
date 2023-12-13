package com.example.apirestkotlin.services

import com.example.apirestkotlin.entity.Credit
import java.util.UUID

interface ICreditService {

    fun save(credit: Credit): Credit
    fun findAllByCustomerId(idCustomer: Long):List<Credit>

    fun findByCreditCode(customerId: Long,creditCode: UUID): Credit
}