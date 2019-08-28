package com.javabom.projectd.service.impl

import com.javabom.projectd.repository.UserRepository
import com.javabom.projectd.service.UserService
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(private val userRepository: UserRepository) : UserService {
}
