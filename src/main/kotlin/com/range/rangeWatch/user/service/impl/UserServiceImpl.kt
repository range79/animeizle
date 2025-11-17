package com.range.rangeWatch.user.service.impl

import com.range.rangeWatch.common.exception.UserNotFoundException
import com.range.rangeWatch.common.util.SecurityContextUtil
import com.range.rangeWatch.user.domain.entity.User
import com.range.rangeWatch.user.domain.repository.UserRepository
import com.range.rangeWatch.user.dto.request.UpdateUserRequest
import com.range.rangeWatch.user.dto.response.UserResponse
import com.range.rangeWatch.user.service.UserService
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


    override fun deleteMe() {
        val id = securityContextUtil.getCurrentUserId()
        val user = userRepository.findById(id).orElseThrow { UserNotFoundException("User not found") }
        user.deleted = true
        userRepository.save(user)
    }

    override fun updateUser(id: UUID, updateUserRequest: UpdateUserRequest) {
      val user = userRepository.findById(id).orElseThrow { UserNotFoundException("User not found") }
        user.username = updateUserRequest.username
        user.email = updateUserRequest.email
        user.twoFactorEnabled = updateUserRequest.twoFactorEnabled
        userRepository.save(user)

    }

    override fun getUserWithEmail(email: String): User {

        return userRepository.findByEmail(email)
            .orElseThrow { UserNotFoundException("User not found") }
    }

    override fun updateUserPassword(id: UUID, newPassword: String) {
        val user = userRepository.findById(id).orElseThrow { UserNotFoundException("User not found") }
        user.password = passwordEncoder.encode(newPassword)
        userRepository.save(user)
    }


}