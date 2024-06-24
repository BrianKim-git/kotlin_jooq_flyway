package com.example.kotlin_jooq_flyway.service

import com.example.kotlin_jooq_flyway.domain.Author
import com.example.kotlin_jooq_flyway.repository.AuthorRepository
import org.springframework.stereotype.Service

@Service
class AuthorService(private var repository: AuthorRepository) : AuthorServiceImpl {

    override fun insert(author: Author) {
        repository.insert(author)
    }

    override fun update(author: Author) {
        repository.update(author)
    }

    override fun find(id:Int): Author? {
        return repository.find(id)
    }

    override fun findAll(): List<Author> {
        return repository.findAll()
    }

    override fun delete(id: Int) {
        repository.delete(id)
    }

}