package com.javabom.projectd.controller

import com.javabom.projectd.constant.MappingUrl
import com.javabom.projectd.service.UserService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(MappingUrl.USER_URL)
class UserController(private val userService: UserService) {

}
