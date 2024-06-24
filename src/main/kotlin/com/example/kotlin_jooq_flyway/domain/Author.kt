package com.example.kotlin_jooq_flyway.domain

import jakarta.annotation.Nullable
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import java.time.LocalDateTime

data class Author(

    @field:NotNull(message = "id는 필수값입니다.")
    var id:Int,

    @field:Nullable
    var firstName:String? = null,

    @field:Nullable
    var lastName:String? = null,

    @field:Nullable
    var dateOfBirth:LocalDateTime? = null,

    @field:Nullable
    @field:Pattern(regexp = "^\\d{4}$", message = "4자리의 숫자만 입력 가능합니다.")
    var yearOfBirth:String? = null
) {
    fun yearOfBirth(): Int? {
        return yearOfBirth?.toIntOrNull()
    }
}
