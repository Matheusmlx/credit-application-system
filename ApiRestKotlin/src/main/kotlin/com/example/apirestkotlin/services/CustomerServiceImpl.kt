package com.example.apirestkotlin.services

import com.example.apirestkotlin.entity.Customer
import com.example.apirestkotlin.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerServiceImpl(private val customerRepository: CustomerRepository) : ICustomerService {
    override fun save(customer: Customer): Customer = customerRepository.save(customer)

    override fun findById(id: Long): Customer = customerRepository.findById(id).orElseThrow {
            throw RuntimeException("Customer não encontrado")
        }
    
    override fun delete(id: Long): Boolean {
        val customer: Customer = this.findById(id);

        customerRepository.delete(customer)

        return true
    }
}