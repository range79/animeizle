package com.range.rangeWatch.user.service.impl

import com.range.rangeWatch.common.exception.UserNotFoundException
import com.range.rangeWatch.common.util.SecurityContextUtil
import com.range.rangeWatch.user.domain.repository.UserRepository
import com.range.rangeWatch.user.dto.request.UpdateUserRequest
import com.range.rangeWatch.user.service.UserCommandService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserCommandServiceImpl(
    private val userRepository: UserRepository,
    private val securityContextUtil: SecurityContextUtil,
    private val passwordEncoder: PasswordEncoder
) :
    UserCommandService {


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



    override fun updateUserPassword(id: UUID, newPassword: String) {
        val user = userRepository.findById(id).orElseThrow { UserNotFoundException("User not found") }
        user.password = passwordEncoder.encode(newPassword)
        userRepository.save(user)
    }


}