package com.mycargonaut.backend.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@Configuration
class SecurityConfig {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf().disable() // Disable CSRF for testing purposes
            .cors() // Enable CORS using the custom configuration source
            .and()
            .authorizeHttpRequests { authorize ->
                authorize
                    .requestMatchers("/", "/api/register", "/api/login").permitAll() // Allow unauthenticated access to these endpoints
                    .anyRequest().authenticated() // All other endpoints require authentication
            }
        return http.build()
    }

    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource {
        val configuration = CorsConfiguration()
        configuration.allowedOrigins = listOf("http://localhost:3000") // Allow requests from the frontend
        configuration.allowedMethods = listOf("GET", "POST", "PUT", "DELETE", "OPTIONS") // HTTP methods
        configuration.allowedHeaders = listOf("*") // Allow all headers
        configuration.allowCredentials = true // Allow credentials (e.g., cookies)

        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", configuration)
        return source
    }
}
