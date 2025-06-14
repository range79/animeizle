package com.range.animeizle.user.service.impl

import com.range.animeizle.user.dao.repository.UserRepository
import com.range.animeizle.user.dto.LoginRequest
import com.range.animeizle.user.dto.RegisterRequest
import com.range.animeizle.user.dto.RegisterResponse
import com.range.animeizle.user.exception.EmailAlreadyRegisteredException
import com.range.animeizle.user.exception.UsernameAlreadyRegisteredException
import com.range.animeizle.user.exception.UsernameOrPasswordBlankException
import com.range.animeizle.user.mapper.UserMapper
import com.range.animeizle.user.service.AuthService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AuthServiceImpl(
    private val userMapper: UserMapper,
    private val userRepository: UserRepository,

    ): AuthService {
    //logger
    private val log: Logger = LoggerFactory.getLogger(AuthServiceImpl::class.java)

    override fun login(loginRequest: LoginRequest) {




    }

    @Transactional
    override fun register(registerRequest: RegisterRequest): RegisterResponse {
        if (userRepository.existsByEmail(registerRequest.email)) {
            log.warn("User with email ${registerRequest.email} already exists.")
            throw EmailAlreadyRegisteredException("Email already registered")
        }
        if (userRepository.existsByUsername(registerRequest.username)) {
            log.warn("User already registered"+registerRequest.username)
            throw UsernameAlreadyRegisteredException("Username already registered")
        }
        log.info("user ${registerRequest.username} registering")

        val savedUser =userRepository.save(
            userMapper.registerRequestToUserEntity(registerRequest)
        )

        return userMapper.userEntityToRegisterResponse(savedUser)


    }
}