package com.javabom.projectd.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class WebSecurityConfig : WebSecurityConfigurerAdapter() {
    override fun configure(httpSecurity: HttpSecurity) {
        val ignorePattern = "/h2-console/**"
        httpSecurity.authorizeRequests()
                .antMatchers(ignorePattern).permitAll()
                .anyRequest().authenticated()
                .and().formLogin()
                .and().csrf().ignoringAntMatchers(ignorePattern)
                .and().headers().frameOptions().sameOrigin()
    }
}
