package com.mycargonaut.backend.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ExampleController {

    @GetMapping("/")
    fun home(): String {
        return "MyCargonaut Backend is Ready!"
    }
}
