package com.mycargonaut.backend.controllers

import com.mycargonaut.backend.entities.User
import com.mycargonaut.backend.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class AuthController(
    @Autowired private val userRepository: UserRepository
) {
    @PostMapping("/register")
    fun register(@RequestBody user: User): ResponseEntity<String> {
        userRepository.save(user)
        return ResponseEntity.ok("User registered successfully")
    }

    @PostMapping("/login")
    fun login(@RequestBody user: User): ResponseEntity<String> {
        val foundUser = userRepository.findByEmail(user.email)
        return if (foundUser != null && foundUser.password == user.password) {
            ResponseEntity.ok("Login successful")
        } else {
            ResponseEntity.status(401).body("Invalid credentials")
        }
    }
}
