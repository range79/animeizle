package com.range.userprofileservice.service.impl

import com.amazonaws.services.s3.AmazonS3
import com.range.userprofileservice.service.ProfilePhotoService
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.util.UUID

@Service
class ProfilePhotoServiceImpl(
    private val s3Client: AmazonS3
): ProfilePhotoService {
    @Value("aws.bucketName")
    private lateinit var bucketName: String
    override fun uploadPhoto(
        multipartFile: MultipartFile,
        filename: String
    ): String {
        val key = "profiles/$filename"
        s3Client.putObject(bucketName, key, multipartFile.inputStream, null)
        return s3Client.getUrl(bucketName, key).toString()
    }

    override fun deletePhoto(filename: String) {
        val key = "profiles/$filename"
        if (s3Client.doesObjectExist(bucketName, key)) {
            s3Client.deleteObject(bucketName, key)
        }
    }

}