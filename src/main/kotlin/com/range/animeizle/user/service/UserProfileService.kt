package com.range.animeizle.user.service

import org.springframework.web.multipart.MultipartFile

interface UserProfileService {

    fun addPhoto(multipartFile: MultipartFile)

    fun addFavorite(id: String)


}