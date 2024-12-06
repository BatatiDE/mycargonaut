package com.mycargonaut.backend.service

import org.springframework.stereotype.Service

@Service
class ExampleService {
    fun getGreeting(): String {
        return "Hello from the Service Layer!"
    }
}
