package com.range.animeWatch.user.service.impl

import com.range.animeWatch.common.exception.UserNotFoundException
import com.range.animeWatch.common.util.SecurityContextUtil
import com.range.animeWatch.user.domain.entity.User
import com.range.animeWatch.user.domain.repository.UserRepository
import com.range.animeWatch.user.dto.request.UpdateUserRequest
import com.range.animeWatch.user.dto.response.UserResponse
import com.range.animeWatch.user.service.UserService
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