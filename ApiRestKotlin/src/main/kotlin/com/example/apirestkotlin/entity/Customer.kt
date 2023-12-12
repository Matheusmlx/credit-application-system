package com.example.apirestkotlin.entity

import jakarta.persistence.*

@Entity
data class Customer(

    @Column(nullable = false)
    var firstName: String = "",
    @Column(nullable = false)
    var lastName: String = "",
    @Column(nullable = false)
    val cpf: String,
    @Column(nullable = false)
    var email: String = "",
    @Column(nullable = false)
    val password: String = "",

    @Column(nullable = false)
    @Embedded
    var address: Address = Address(),

    @OneToMany(
        fetch = FetchType.LAZY,
        cascade = [CascadeType.REMOVE],
        mappedBy = "customer"
    )
    var credts: List<Credit> = mutableListOf(),

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long? = null
)
