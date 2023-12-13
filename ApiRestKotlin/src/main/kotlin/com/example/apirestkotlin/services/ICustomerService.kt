package com.example.apirestkotlin.services

import com.example.apirestkotlin.entity.Customer

interface ICustomerService {
    fun save(customer: Customer):Customer
    fun findById(id: Long):Customer
    fun delete(id: Long): Boolean
}