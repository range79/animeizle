package com.range.animeizle.user.service.impl

import com.range.animeizle.common.exception.UserNotFoundException
import com.range.animeizle.common.util.SecurityContextUtil
import com.range.animeizle.user.domain.entity.User
import com.range.animeizle.user.domain.repository.UserRepository
import com.range.animeizle.user.dto.request.UpdateUserRequest
import com.range.animeizle.user.dto.response.UserResponse
import com.range.animeizle.user.service.UserService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val securityContextUtil: SecurityContextUtil,
    private val passwordEncoder: PasswordEncoder
) :
    UserService {
    override fun me(): UserResponse {

        val id = securityContextUtil.getCurrentUserId()
        val user = userRepository.findById(id).orElseThrow { UserNotFoundException("User Not found") }
        TODO()
    }

    override fun getUser(id: UUID): User {
        return userRepository.findById(id)
            .orElseThrow { UserNotFoundException("User not found") }

    }


    override fun delete() {
        val id = securityContextUtil.getCurrentUserId()
        val user = userRepository.findById(id).orElseThrow { UserNotFoundException("User not found") }
        user.deleted = true
        userRepository.save(user)
    }

    override fun update(id: UUID, updateUserRequest: UpdateUserRequest) {
      val user = userRepository.findById(id).orElseThrow { UserNotFoundException("User not found") }
        user.username = updateUserRequest.username
        user.email = updateUserRequest.email
        user.password = passwordEncoder.encode(updateUserRequest.password)
        user.twoFactorEnabled = updateUserRequest.twoFactorEnabled
        userRepository.save(user)

    }


}