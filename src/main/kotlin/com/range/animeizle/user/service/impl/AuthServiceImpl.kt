package com.range.animeizle.user.service.impl

import com.range.animeizle.user.dao.repository.UserRepository
import com.range.animeizle.user.dto.LoginRequest
import com.range.animeizle.user.dto.RegisterRequest
import com.range.animeizle.user.dto.RegisterResponse
import com.range.animeizle.user.exception.EmailAlreadyRegistered
import com.range.animeizle.user.exception.UsernameOrPasswordBlank
import com.range.animeizle.user.mapper.UserMapper
import com.range.animeizle.user.service.AuthService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Service
class AuthServiceImpl(
    private val userMapper: UserMapper,
    private val userRepository: UserRepository,

): AuthService {
    //logger
    private val log: Logger = LoggerFactory.getLogger(AuthServiceImpl::class.java)

    override fun login(loginRequest: LoginRequest) {
    if (loginRequest.usernameOrEmail.isBlank() || loginRequest.password.isBlank()) {
        throw UsernameOrPasswordBlank("Username or password is blank")
    }
        if (loginRequest.usernameOrEmail.contains("@")){

        }



    }

    @Transactional
    override fun register(registerRequest: RegisterRequest): RegisterResponse {
if (userRepository.existsByEmail(registerRequest.email)) {
    throw EmailAlreadyRegistered("Email already registered")
}
        log.info("user ${registerRequest.username} registering")

        val savedUser =userRepository.save(
            userMapper.registerRequestToUserEntity(registerRequest)
        )

        return userMapper.userEntityToRegisterResponse(savedUser)


    }
}