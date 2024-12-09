package com.mycargonaut.backend.entities

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val email: String,
    val password: String,
    val role: String = "USER"
)
