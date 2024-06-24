package com.example.kotlin_jooq_flyway.controller

import com.example.kotlin_jooq_flyway.domain.Author
import com.example.kotlin_jooq_flyway.domain.ErrorResponse
import com.example.kotlin_jooq_flyway.service.AuthorServiceImpl
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(("/api/author"))
class ApiAuthorController(val service: AuthorServiceImpl) {

    @PostMapping("/")
    fun insert(@Valid @RequestBody author: Author, bindingResult: BindingResult): ResponseEntity<Any> {
        val response: ResponseEntity<Any>
        if (bindingResult.hasErrors()) {
            response = ResponseEntity.badRequest().body(
                ErrorResponse(
                    HttpStatus.BAD_REQUEST,
                    bindingResult.fieldErrors.stream()
                        .map { e -> e.defaultMessage }.toList()
                )
            )
        } else {
            service.insert(author)
            response = ResponseEntity.ok("success")
        }
        return response
    }

    @PutMapping("/")
    fun update(@Valid @RequestBody author: Author, bindingResult: BindingResult): ResponseEntity<Any> {
        val response: ResponseEntity<Any>
        if (bindingResult.hasErrors()) {
            response = ResponseEntity.badRequest().body(
                ErrorResponse(
                    HttpStatus.BAD_REQUEST,
                    bindingResult.fieldErrors.stream()
                        .map { e -> e.defaultMessage }.toList()
                )
            )
        } else {
            service.update(author)
            response = ResponseEntity.ok("success")
        }
        return response
    }

    @GetMapping("/")
    fun readAll(): ResponseEntity<List<Author>> {
        return ResponseEntity.ok(service.findAll())
    }

    @GetMapping("/{id}")
    fun read(@PathVariable(name = "id", required = true) id: Int): ResponseEntity<Author> {
        return ResponseEntity.ok(service.find(id))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable(name = "id", required = true) id: Int) {
        service.delete(id)
    }
}