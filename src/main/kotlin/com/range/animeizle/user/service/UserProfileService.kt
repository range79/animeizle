package com.range.animeizle.user.service

import com.range.animeizle.user.dao.model.User
import org.springframework.web.multipart.MultipartFile

interface UserProfileService {

    fun addPhoto(multipartFile: MultipartFile)

    fun addFavorite(id: String)


}