package com.range.animeizle.common.service
import org.springframework.web.multipart.MultipartFile

interface AmazonService {
    fun addPhoto(bucketName: String, file: MultipartFile, fileName: String):String
    fun deletePhoto(bucketName: String, filename: String?)
}