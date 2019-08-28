package com.javabom.projectd.controller

import com.javabom.projectd.constant.MappingUrl
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(MappingUrl.PRIVATE)
class PublicController {

    @GetMapping
    fun getMessage(): String {
        return "Hello, Private!"
    }
}
