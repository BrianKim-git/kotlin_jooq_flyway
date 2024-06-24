package com.example.kotlin_jooq_flyway.service

import com.example.kotlin_jooq_flyway.domain.Author

interface AuthorServiceImpl {
    fun insert(author: Author)
    fun update(author: Author)
    fun find(id:Int): Author?
    fun findAll(): List<Author>
    fun delete(id:Int)
}