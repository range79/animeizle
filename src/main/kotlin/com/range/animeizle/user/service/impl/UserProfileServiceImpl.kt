package com.range.animeizle.user.service.impl

import com.range.animeizle.user.domain.repository.UserProfileRepository
import com.range.animeizle.user.service.UserProfileService
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
@Service
class UserProfileServiceImpl(
    private val userprofileRepository: UserProfileRepository
) : UserProfileService {
    override fun addPhoto(multipartFile: MultipartFile) {
        TODO()
        multipartFile.originalFilename?.let { fileName ->fileName }
    }



    override fun addFavorite(id: String) {
        TODO()
    }
}
