package com.example.apirestkotlin.entity

import com.example.apirestkotlin.enummeration.Status
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID
@Entity
@Table(name = "Credit")
data class Credit(
    @Column(unique = true, nullable = false)
    val creditCode: UUID = UUID.randomUUID(),

    @Column(nullable = false)
    val creditValue: BigDecimal = BigDecimal.ZERO,
    @Column(nullable = false)
    val dayFirstInstallment: LocalDate,
    @Column(nullable = false)
    val numberOfInstallments: Int = 0,

    @Enumerated
    val status: Status = Status.IN_PROGRESS,

    @ManyToOne
    val customer: Customer? = null,
    @Column(nullable = false)

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
    )
