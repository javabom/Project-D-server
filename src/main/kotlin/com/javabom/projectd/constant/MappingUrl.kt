package com.javabom.projectd.constant

object MappingUrl {
    private const val BASE_URL = "/api/v1"
    const val AUTH_LOGIN_URL = "$BASE_URL/authenticate"
    const val PUBLIC = "$BASE_URL/public"
    const val PRIVATE = "$BASE_URL/private"
}
