package com.example.apirestkotlin.services

import com.example.apirestkotlin.entity.Credit
import com.example.apirestkotlin.repository.CreditRepository
import java.util.*

class CreditServiceImpl(private val creditRepository: CreditRepository,
    private val customerService: ICustomerService
    ): ICreditService {
    override fun save(credit: Credit): Credit {
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }
        return creditRepository.save(credit)
    }

    override fun findAllByCustomerId(idCustomer: Long): List<Credit> = creditRepository.findAllByCustomerId(idCustomer)

    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
        val credit: Credit = creditRepository.findByCreditCode(creditCode) ?: throw RuntimeException("Not Found $creditCode")
        return if (credit.customer?.id == customerId) credit else throw RuntimeException("Contact admin")
    }
}