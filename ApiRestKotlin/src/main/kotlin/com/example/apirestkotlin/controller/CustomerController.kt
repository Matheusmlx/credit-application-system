package com.example.apirestkotlin.controller

import com.example.apirestkotlin.entity.Customer
import com.example.apirestkotlin.services.CustomerServiceImpl
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController(private val customerServiceImpl: CustomerServiceImpl) {
    @PostMapping
    fun createUser(@RequestBody customer: Customer) {
        customerServiceImpl.save(customer)
    }

    @GetMapping("/customer/{id}")
    fun customers(@PathVariable id: Number):Customer = customerServiceImpl.findById(id.toLong());
}