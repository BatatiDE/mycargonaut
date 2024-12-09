package com.mycargonaut.backend.repositories

import com.mycargonaut.backend.entities.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findByEmail(email: String): User?
}
