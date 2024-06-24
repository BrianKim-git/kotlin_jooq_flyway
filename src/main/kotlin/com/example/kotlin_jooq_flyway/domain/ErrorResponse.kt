package com.example.kotlin_jooq_flyway.domain

import org.springframework.http.HttpStatus

data class ErrorResponse(
    val status: HttpStatus,
    val message: MutableList<String?>
)