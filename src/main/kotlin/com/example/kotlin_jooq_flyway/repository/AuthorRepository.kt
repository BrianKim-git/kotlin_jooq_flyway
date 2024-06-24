package com.example.kotlin_jooq_flyway.repository

import com.example.kotlin_jooq_flyway.domain.Author
import jooq.dsl.tables.JAuthor
import org.jooq.DSLContext
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
class AuthorRepository(var dsl: DSLContext) : AuthorRepositoryImpl {

    val jAuthor: JAuthor = JAuthor.AUTHOR

    @Transactional
    override fun insert(author: Author) {
        dsl.insertInto(
            jAuthor,
            jAuthor.ID,
            jAuthor.LAST_NAME,
            jAuthor.FIRST_NAME,
            jAuthor.DATE_OF_BIRTH,
            jAuthor.YEAR_OF_BIRTH
        ).values(
            author.id,
            author.lastName,
            author.firstName,
            author.dateOfBirth,
            author.yearOfBirth()
        ).execute()
    }

    @Transactional
    override fun update(author: Author) {
        dsl.update(
            jAuthor
        ).set(jAuthor.LAST_NAME, author.lastName)
         .set(jAuthor.FIRST_NAME, author.firstName)
         .set(jAuthor.DATE_OF_BIRTH, author.dateOfBirth)
         .set(jAuthor.YEAR_OF_BIRTH, author.yearOfBirth())
        .where(jAuthor.ID.eq(author.id))
            .execute()
    }

    @Transactional(readOnly = true)
    override fun find(id: Int): Author? {
        return dsl.selectFrom(JAuthor.AUTHOR)
            .where(JAuthor.AUTHOR.ID.eq(id))
            .fetchOneInto(Author::class.java)
    }

    @Transactional(readOnly = true)
    override fun findAll(): List<Author> {
        return dsl.selectFrom(JAuthor.AUTHOR)
            .fetchInto(Author::class.java)
    }

    @Transactional
    override fun delete(id: Int) {
        dsl.deleteFrom(JAuthor.AUTHOR)
            .where(JAuthor.AUTHOR.ID.eq(id))
            .execute()
    }
}