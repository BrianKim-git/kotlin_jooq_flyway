package com.example.kotlin_jooq_flyway.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class HomeController {

    @RequestMapping("/")
    fun home(): String {
        return "index"
    }
}