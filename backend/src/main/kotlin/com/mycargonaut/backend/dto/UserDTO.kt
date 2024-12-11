package com.mycargonaut.backend.dto

data class UserDTO(
    val id: Long,
    val email: String,
    val name: String?,
    val birthdate: String?,
    val phone: String?,
    val role: String,
    val isVerified: Boolean,
    val createdAt: String,
    val updatedAt: String
)
