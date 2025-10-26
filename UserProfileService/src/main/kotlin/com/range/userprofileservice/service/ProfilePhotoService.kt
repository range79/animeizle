package com.range.userprofileservice.service

import org.springframework.web.multipart.MultipartFile
import java.util.UUID

interface ProfilePhotoService{
    fun uploadPhoto(multipartFile: MultipartFile,filename:String): String
    fun deletePhoto(filename:String)
}