package com.range.rangeWatch.common.service
import org.springframework.web.multipart.MultipartFile

interface PhotoService {
    fun addPhoto(bucketName: String, file: MultipartFile, fileName: String):String
    fun deletePhoto(bucketName: String, filename: String?)
}