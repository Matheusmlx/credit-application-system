package com.example.apirestkotlin.repository

import com.example.apirestkotlin.entity.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface CreditRepository: JpaRepository<Credit, Long> {
    fun findByCreditCode(creditCode: UUID) : Credit?

    fun findAllByCustomerId(customerId: Long) : List<Credit>
}