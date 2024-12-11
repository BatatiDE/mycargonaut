package com.mycargonaut.backend.controllers

import com.mycargonaut.backend.config.JwtService
import com.mycargonaut.backend.dto.UserDTO
import com.mycargonaut.backend.entities.User
import com.mycargonaut.backend.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class AuthController(
    @Autowired private val userRepository: UserRepository,
    @Autowired private val passwordEncoder: PasswordEncoder,
    @Autowired private val jwtService: JwtService
) {

    @PostMapping("/register")
    fun register(@RequestBody user: User): ResponseEntity<String> {
        if (userRepository.findByEmail(user.email) != null) {
            return ResponseEntity.status(400).body("Email is already registered")
        }

        val newUser = user.copy(password = passwordEncoder.encode(user.password))
        userRepository.save(newUser)
        return ResponseEntity.ok("User registered successfully")
    }



    @PostMapping("/login")
    fun login(@RequestBody user: User): ResponseEntity<Any> {
        try {
            // Check if the user exists
            val foundUser = userRepository.findByEmail(user.email)
                ?: return ResponseEntity.status(401).body("Invalid email or password")

            // Validate the password
            if (!passwordEncoder.matches(user.password, foundUser.password)) {
                return ResponseEntity.status(401).body("Invalid email or password")
            }

            // Generate a JWT token
            val token = jwtService.generateToken(foundUser.email)

            // Create a UserDTO for the response
            val userDTO = UserDTO(
                id = foundUser.id!!,
                email = foundUser.email,
                name = foundUser.name,
                birthdate = foundUser.birthdate?.toString(),
                phone = foundUser.phone,
                role = foundUser.role,
                isVerified = foundUser.isVerified,
                createdAt = foundUser.createdAt.toString(),
                updatedAt = foundUser.updatedAt.toString()
            )

            // Return the token and the UserDTO
            return ResponseEntity.ok(mapOf("token" to token, "user" to userDTO))

        } catch (e: Exception) {
            return ResponseEntity.status(500).body("Error: ${e.message}")
        }
    }
}
