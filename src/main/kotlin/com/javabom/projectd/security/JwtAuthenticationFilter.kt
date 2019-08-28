package com.javabom.projectd.security

import com.javabom.projectd.constant.MappingUrl
import com.javabom.projectd.constant.SecurityConst
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import java.util.Date
import java.util.stream.Collectors
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtAuthenticationFilter : UsernamePasswordAuthenticationFilter() {

    init {
        setFilterProcessesUrl(MappingUrl.AUTH_LOGIN_URL)
    }

    override fun attemptAuthentication(request: HttpServletRequest?, response: HttpServletResponse?): Authentication {
        val username = request?.getParameter("username")
        val password = request?.getParameter("password")
        val authenticationToken = UsernamePasswordAuthenticationToken(username, password)
        return authenticationManager.authenticate(authenticationToken)
    }

    override fun successfulAuthentication(request: HttpServletRequest?, response: HttpServletResponse?, chain: FilterChain?, authResult: Authentication?) {
        val user = authResult?.principal as User
        val roles = user.authorities
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList())
        val signingKey = SecurityConst.JWT_SECRET.toByteArray()
        val token = Jwts.builder()
                .signWith(Keys.hmacShaKeyFor(signingKey), SignatureAlgorithm.HS512)
                .setHeaderParam("typ", SecurityConst.TOKEN_TYPE)
                .setIssuer(SecurityConst.TOKEN_ISSUER)
                .setAudience(SecurityConst.TOKEN_AUDIENCE)
                .setSubject(user.username)
                .setExpiration(Date(System.currentTimeMillis() + 864000000))
                .claim("rol", roles)
                .compact()

        response?.addHeader(SecurityConst.TOKEN_HEADER, SecurityConst.TOKEN_PREFIX + token)
    }
}
