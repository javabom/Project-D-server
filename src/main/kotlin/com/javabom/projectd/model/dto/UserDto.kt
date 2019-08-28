package com.javabom.projectd.model.dto

import javax.validation.constraints.Email

data class UserDto(
        val name: String?,
        @Email
        val email: String?,
        val password: String
)
