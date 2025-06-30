package com.range.animeizle.user.service.impl

import com.range.animeizle.common.CustomSecurityContext
import com.range.animeizle.user.domain.repository.UserProfileRepository
import com.range.animeizle.user.exception.UserProfileNotFoundException
import com.range.animeizle.user.service.UserProfileService
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
@Service
class UserProfileServiceImpl(
    private val userprofileRepository: UserProfileRepository,
    private val mySecurityContext: CustomSecurityContext
) : UserProfileService {
    override fun addPhoto(multipartFile: MultipartFile) {

        val user =  userprofileRepository.findById(  mySecurityContext.getUserId()).orElseThrow{
            UserProfileNotFoundException("User profile not found")
        }
        user.profileImg= multipartFile.bytes
        userprofileRepository.save(user)
        TODO()

    }



    override fun addFavorite(id: String) {
               TODO()
    }
}
