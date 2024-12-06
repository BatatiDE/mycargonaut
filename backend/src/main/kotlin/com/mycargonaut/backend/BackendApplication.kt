package com.mycargonaut.backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BackendApplication

fun main(args: Array<String>) {
	val context = runApplication<BackendApplication>(*args)
	println("Beans loaded by Spring:")
	context.beanDefinitionNames.sorted().forEach(::println)
}
