package com.range.animeizle.user.service.impl

import com.range.animeizle.common.util.JwtUtil
import com.range.animeizle.user.domain.entity.Role
import com.range.animeizle.user.domain.entity.User
import com.range.animeizle.user.domain.repository.UserRepository
import com.range.animeizle.user.dto.LoginRequest
import com.range.animeizle.user.dto.RegisterRequest
import com.range.animeizle.user.exception.RequiredFieldNullException
import com.range.animeizle.user.mapper.UserMapper
import com.range.animeizle.user.service.helper.AuthServiceHelper
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
@ExtendWith(MockitoExtension::class)
class AuthServiceImplTest {

    @Mock
    private lateinit var passwordEncoder: PasswordEncoder
    @Mock
    private lateinit var userRepository: UserRepository
    @Mock
    private lateinit var jwtUtil: JwtUtil
    @Mock
    private lateinit var authServiceHelper: AuthServiceHelper
    @InjectMocks
    private lateinit var authServiceImpl: AuthServiceImpl
    private lateinit var loginRequest: LoginRequest
    private lateinit var registerRequest: RegisterRequest
    private lateinit var user: User
    @Mock
    private lateinit var userMapper: UserMapper




    @BeforeEach
    fun setUp() {
        loginRequest= LoginRequest("range","range123")
        user= User(1L,"range","range@gmail.com","range123", Role.ROLE_USER)

        registerRequest= RegisterRequest("range","range@gmail.com","range123")
    }


    @Test
    fun login() {

        Mockito.`when`(passwordEncoder.matches(loginRequest.password, user.password)).thenReturn(true)
        Mockito.`when`(jwtUtil.generateToken(user.id, user.role)).thenReturn("jwt-token")
        Mockito.`when`(authServiceHelper.findUserByUsernameOrEmail(loginRequest.usernameOrEmail))
            .thenReturn(user)
        val token = authServiceImpl.login(loginRequest)
        assertEquals("jwt-token", token)

        verify(authServiceHelper).findUserByUsernameOrEmail(loginRequest.usernameOrEmail)
        verify(passwordEncoder).matches(loginRequest.password, user.password)
        verify(jwtUtil).generateToken(user.id, user.role)

    }

    @Test
    fun register() {
        Mockito.`when`(userRepository.save(user)).thenReturn(user)
        Mockito.`when`(jwtUtil.generateToken(user.id,user.role)).thenReturn("jwt-token")
        Mockito.`when`(passwordEncoder.encode(registerRequest.password)).thenReturn("<PASSWORD>")
        Mockito.`when`(userMapper.registerRequestToUserEntity(registerRequest)).thenReturn(user)
        assertEquals("jwt-token", authServiceImpl.register(registerRequest))
        verify(jwtUtil).generateToken(user.id,user.role)
        verify(userRepository).save(user)

    }
    @Test
    fun `should return exception if LoginRequest is null`(){
        assertThrows <RequiredFieldNullException>{
            authServiceImpl.login(null)
        }

    }
    @Test
    fun `should return exception if RegisterRequest is null`(){
        assertThrows <RequiredFieldNullException>{
            authServiceImpl.register(null)
        }
    }
    @Test
    fun `should throw exception if user password not match`(){
        Mockito.`when`(authServiceHelper.findUserByUsernameOrEmail(loginRequest.usernameOrEmail))
            .thenReturn(user)
        Mockito.`when`(passwordEncoder.matches(loginRequest.password, user.password)).thenReturn(false)
        assertThrows <Exception>{
            authServiceImpl.login(loginRequest)
        }
    }
    fun `should throw exception if user not found`(){
        Mockito.`when`(authServiceHelper.findUserByUsernameOrEmail(loginRequest.usernameOrEmail))
            .thenReturn(null)
        assertThrows <UsernameNotFoundException>{authServiceImpl.login(loginRequest)}
    }

}