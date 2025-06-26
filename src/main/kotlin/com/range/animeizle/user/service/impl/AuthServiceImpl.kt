package com.range.animeizle.user.service.impl
import com.range.animeizle.common.util.JwtUtil
import com.range.animeizle.user.domain.repository.UserRepository
import com.range.animeizle.user.dto.LoginRequest
import com.range.animeizle.user.dto.RegisterRequest
import com.range.animeizle.user.exception.EmailAlreadyRegisteredException
import com.range.animeizle.user.exception.PasswordIncorrectException
import com.range.animeizle.user.exception.RequiredFieldNullException
import com.range.animeizle.user.exception.UsernameAlreadyRegisteredException
import com.range.animeizle.user.mapper.UserMapper
import com.range.animeizle.user.service.AuthService
import com.range.animeizle.user.service.helper.AuthServiceHelper
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AuthServiceImpl(
    private val userMapper: UserMapper,
    private val userRepository: UserRepository,
    private val authServiceHelper: AuthServiceHelper,
    private val jwtUtil: JwtUtil,
    private val passwordEncoder: PasswordEncoder

): AuthService {
    //logger
    private val log: Logger = LoggerFactory.getLogger(AuthServiceImpl::class.java)

    override fun login(loginRequest: LoginRequest?): String {
        if (loginRequest == null) {
            throw RequiredFieldNullException("You must provide a valid login request")
        }
        val user = authServiceHelper.findUserByUsernameOrEmail(loginRequest.usernameOrEmail )

        if (!passwordEncoder.matches(loginRequest.password, user!!.password)) {
            log.warn("Invalid password {}", loginRequest.usernameOrEmail)
            throw PasswordIncorrectException("Password is incorrect")
        }
        return  jwtUtil.generateToken(user.username,user.role)

    }

    @Transactional
    override fun register(registerRequest: RegisterRequest?): String {
        if (registerRequest == null) {
            log.warn("You must provide a valid login request")
            throw RequiredFieldNullException("You must provide a valid register request")
        }

        if (userRepository.existsByEmail(registerRequest.email)) {
            log.warn("Register attempt with already existing email: {}", registerRequest.email.take(3) + "***")
            throw EmailAlreadyRegisteredException("Email already registered")
        }
        if (userRepository.existsByUsername(registerRequest.username)) {
            log.warn("User already registered"+registerRequest.username)
            throw UsernameAlreadyRegisteredException("Username already registered")
        }
        log.debug("user ${registerRequest.username} registering")
        val user =  userMapper.registerRequestToUserEntity(registerRequest)
        user.password = passwordEncoder.encode(registerRequest.password)
        val savedUser =userRepository.save(user)
        log.debug("saved user ${savedUser.username} to database")

        return jwtUtil.generateToken(savedUser.username,savedUser.role)


    }
}