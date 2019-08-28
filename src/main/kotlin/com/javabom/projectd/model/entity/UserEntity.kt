package com.javabom.projectd.model.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "USER")
data class UserEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @Column(unique = true, nullable = false)
        val username: String,

        @Column(unique = true, nullable = false)
        val email: String,

        @JsonIgnore
        @Column(nullable = false)
        val password: String
)
